package com.bigroi.classwork.lesson06.shop;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class ProductDaoFileImpl implements Closeable {
	
	private RandomAccessFile dataFile = null;
	
	public ProductDaoFileImpl() throws DaoException {
		try {
			File dir = new File("D:\\temp\\database");
			dir.mkdirs();
			if ( !dir.exists() ) {
				throw new DaoException("Wrong path to data file " + dir.getAbsolutePath());
			}
			dataFile = new RandomAccessFile("D:\\temp\\database\\products.dbt", "rw");
		} catch (FileNotFoundException e) {
			throw new DaoException("Could not initialize data file", e);
		}
	}

	/**
	 * Сохраняет объект Product в файл путем создания записи в файле длиной 140 байт. Запись состоит из 3-х частей (полей):
	 *   - поле code - имеет длину 8 байт 
	 *   - поле name - имеет длину 100 байт
	 *   - поле price - имеет длину 32 байта
	 * @param product
	 * @throws DaoException
	 */	
	public void insertProduct(Product product) throws DaoException {
		// buffer - массив-буфер - заполняем его данными из объекта
		// code будет храниться в buffer начиная с индекса 0 и заканчивая индексом 7: [0,7]
		// name будет храниться в диапазоне индексов 8 и 107 (включая): [8, 107] 
		// price будет храниться в диапазоне [108, 140]
		byte[] buffer = new byte[140];
		
		// преобразуем символы поля code в массив байтов
		String code = product.getCode();
		byte[] codeBuffer = code.getBytes();
		// проверяем длину массива; если превосходит 8, то выбрасываем исключение
		if (codeBuffer.length > 8) {
			throw new DaoException("Could not write to file");
		}
		// копируем все байты из массива codeBuffer в массив buffer		
		System.arraycopy(
				codeBuffer, 
				0 /* индекс массива codeBuffer, начиная с которого берем байты из codeBuffer */, 
				buffer, 
				0 /* индекс массива buffer, начиная с которого пишем байты в buffer */, 
				codeBuffer.length /* количество копируемых байтов из buffer - весь массив в нашем случае*/
				);
		
		// записываем name в buffer
		String name = product.getName();
		byte[] nameBuffer = name.getBytes();
		if (nameBuffer.length > 100) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(nameBuffer, 0, buffer, 8, nameBuffer.length);
		
		
		// записываем price в buffer
		BigDecimal price = product.getPrice();
		// price для простоты преобразовываем сначала в строку, затем в byte-массив
		byte[] priceBuffer = price.toString().getBytes();
		if (nameBuffer.length > 32) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(priceBuffer, 0, buffer, 108, priceBuffer.length);
		
		try {
			// пишем наш buffer в файл
			dataFile.write(buffer);
		} catch (IOException e) {
			throw new DaoException("Could not write to file", e);
		}
		
	}
	
	/**
	 * Читает из файла запись с номером n; прочитанные поля помещает в новый объект product
	 * @param n
	 * @return - product
	 * @throws DaoException
	 */
	public Product getProductByRecordNo(int n) throws DaoException {
		Product product = null;
		try {
			// n * 140 - индекс байта, начиная с которого будем считывать поля из файла			 
			dataFile.seek(n * 140);
			
			// читаем 1-ые 8 байт в массив codeBuffer
			byte[] codeBuffer = new byte[8];
			dataFile.read(codeBuffer);
			// преобразуем массив codeBuffer в строку
			String code = new String(codeBuffer);
			// удаляем пробелы слева / справа
			code = code.trim();
			
			// читаем следующие 100 байт и т.д.
			byte[] nameBuffer = new byte[100];
			dataFile.read(nameBuffer);
			String name = new String(nameBuffer).trim();
			
			byte[] priceBuffer = new byte[32];
			dataFile.read(priceBuffer);
			String price = new String(priceBuffer);
			
			product = new Product(code, name, Double.parseDouble(price));
		} catch (IOException e) {
			throw new DaoException("Could not read file", e);
		}		
		return product;
	}
	
//	public Product getProductByCode(String code) throws DaoException {
//		Product product = null;//new Product();
//		return product;
//	}

	@Override
	public void close() {
		if (dataFile != null) {
			try {
				dataFile.close();
				System.out.println("Product data file is closed");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}
