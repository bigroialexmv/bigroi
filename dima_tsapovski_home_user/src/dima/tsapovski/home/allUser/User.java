package dima.tsapovski.home.allUser;


	import java.math.BigDecimal;
	public class User {
	
		
		private String UserName;
		
		private String Mail;
		
		private BigDecimal Age;

		/**
		 * Creates new user
		 * @param UserName User UserName
		 * @param Mail User Mail
		 * @param Age User Age
		 */
		public User (String UserName, String Mail, BigDecimal Age) {
			super();
			if ( UserName == null ) {
				throw new IllegalArgumentException("code must not be null");
			}
			if ( Mail == null ) {
				throw new IllegalArgumentException("name must not be null");
			}
			this.UserName = UserName;
			this.Mail = Mail;
			this.Age = Age;
		}
		
		public User(String UserName, String Mail, double Age) {	
			this(UserName, Mail, new BigDecimal(Age) );
		}

		public String getUserName() {
			return UserName;
		}

		public String getMail() {
			return Mail;
		}

		public BigDecimal getAge() {
			return Age;
		}
		
		@Override
		public String toString() {
			String s = String.format("User {UserName=%s, Mail=%s,  Age=%s}", UserName, Mail,  Age);
			return s;
		}
		
	}

