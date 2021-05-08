package me.jiantailang.api.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class HmacUtil {

	private HmacUtil() {}

	public enum Algorithm {

		SHA224("HmacSHA224"),
		SHA256("HmacSHA256"),
		SHA384("HmacSHA384"),
		SHA512("HmacSHA512");

		private String value;

		Algorithm(String value) {
			this.value = value;
		}

		private String getValue() {
			return this.value;
		}
	}

	public static String hash(String secretKey, String message) throws NoSuchAlgorithmException, InvalidKeyException {
		return hash(secretKey, message, Algorithm.SHA256);
	}

	public static String hash(String secretKey, String message, Algorithm algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance(algorithm.getValue());
		mac.init(new SecretKeySpec(secretKey.getBytes(), algorithm.getValue()));
		byte[] mac_bytes = mac.doFinal(message.getBytes());
		StringBuilder sb = new StringBuilder(2 * mac_bytes.length);
		for (byte b : mac_bytes) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString().toLowerCase(Locale.ENGLISH);
	}
}
