package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CredentialSave {
	
	


	private static String email = "f.scarmozzino@3em.it";
	private static String smtpUser = "smtp@3em.it";
	private static String smtpPassword = "qCcHVn4WbgVwckW@";
	
	
	private static String oggetto = "Busta Paga:";
	
	
	public static void setEmail(String email) {
		CredentialSave.email = email;
	}
	
	public static String getEmail() {
		return email;
	}
	
	public static String getOggetto() {
		return oggetto;
	}
	
	public static String getSmtpUser() {
		return smtpUser;
	}

	public static void setSmtpUser(String smtpUser) {
		CredentialSave.smtpUser = smtpUser;
	}

	public static String getSmtpPassword() {
		return smtpPassword;
	}

	public static void setSmtpPassword(String smtpPassword) {
		CredentialSave.smtpPassword = smtpPassword;
	}
	
	
	public static void setCredenziali() {
		Properties p = new Properties();
		try {
			p.load(new FileReader(System.getenv("APPDATA") + "/bp3em.properties"));
			email = p.getProperty("email", email);
			smtpPassword = p.getProperty("smtpPassword", smtpPassword);
			smtpUser = p.getProperty("smtpUser", smtpUser);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setOther() {
		Properties p = new Properties();
		try {
			p.load(new FileReader(System.getenv("APPDATA") + "/bp3em.properties"));
			oggetto = p.getProperty("oggetto", oggetto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
