/**
 * 
 */
package source;

import java.util.Arrays;

/**
 * @author greghab
 *
 */
public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 0 to 15 
		char[] five = new char[16];
		for (int i = 0; i <= 12; i++) {
			five[i] = '0';
		}
		five[13] = '1';
		five[14] = '0';
		five[15] = '1';

		char[] negFive = new char[16];
		for (int i = 0; i <= 10; i++) {
			negFive[i] = '1';
		}
		negFive[11] = '1';
		negFive[12] = '1';
		negFive[13] = '0';
		negFive[14] = '1';
		negFive[15] = '1';

		System.out.println("five is " + Arrays.toString(five));
		System.out.println("convert 5 binary to decmimal: " + convert2sCompToDecimal(five));
		System.out.println("convert -5 binary to decmimal: " + convert2sCompToDecimal(negFive));

		System.out.println("convert 5 decimal to binary: " + Arrays.toString(convertDecimalTo2sComp(5)));

		System.out.println("-5 is " + Arrays.toString(negFive));
		System.out.println(convertNegPos(negFive));


	}
	// Takes an array of bits to return the corresponding 
	// decimal equivalent. 
	public static int convert2sCompToDecimal(char[] bits) {
		//TODO fix this

		// start at 15 (16), count down to 0 (1).
		// traverse left to right of input.
		char[] input = cloneArray(bits);

		//  TODO clone bits, if negative input, use positive input, return -1 output.

		// if negative 2s complement given, make decimal output negative.
		int val = 0;
		if(bits[0] == '1') {
			// evalute decimal value for + binary value, return output * -1 (for a negative value)
			input = convertNegPos(input);
			for (int i = 0; i <= 15; i++) {
				if(input[i] == '1') {
					val += (int) Math.pow(2.0, 1.0 * (15-i));
				}
			}
			val *= -1;
		} else {
			for (int i = 0; i <= 15; i++) {
				if(input[i] == '1') {
					val += (int) Math.pow(2.0, 1.0 * (15-i));
				}
			}
		}

		return val;
	}

	private static char[] cloneArray(char[] bits) {
		char[] out = new char[16];
		for (int i = 0; i <= 15; i++) {
			out[i] = bits[i];
		}
		return out;
	}



	// Takes a decimal and returns the 2s complement equivalent. 
	// Assume that the decimal value won’t require more than 16 bits.  
	public static char[] convertDecimalTo2sComp(int decimal) {
		if(decimal >= 0) {
			return convertDecimalPositive(decimal);
		}
		return new char[16];
	}

	// Takes a decimal and returns the 2s complement equivalent. 
	// Assume that the decimal value won’t require more than 16 bits.  
	private static char[] convertDecimalPositive(int decimal) {
		char[] out = new char[16];
		// starts at 2^15
		// positive numbers
		// go through left to right, check if you can add highest binary then subtract that value.
		for (int i = 0; i <= 15; i++) {
			int binVal = (int) Math.pow(2.0, 1.0 * (15-i));
			if(binVal <= decimal) {
				out[i] = '1';
				decimal -= binVal;
			} else {
				out[i] = '0';
			}
		}
		return out;
	}

	private static char[] convertNegPos(char[] bits) {
		char[] pos = new char[16];
		boolean notEncounteredOne = true;
		for(int i = 15; i >= 0; i--) {
			if(notEncounteredOne) {
				if(bits[i] == '1') {
					notEncounteredOne = false;
				} 
				// don't change bit
				pos[i] = bits[i];
			} else { //swap
				if (bits[i] == '1') {
					pos[i] = '0';
				} else {
					pos[i] = '1';
				}
			}
		}
		return pos;
	}



}



/**
 * 
 */
package source;

import static org.junit.Assert.*;		

import org.junit.Test;

/**
 * @author greghab
 *
 */
public class ConvertTest {


	/**
	 * Test method for {@link source.Convert#convert2sCompToDecimal(char[])}.
	 */
	@Test
	public void testConvert2sCompToDecimal() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link source.Convert#convertDecimalTo2sComp(int)}.
	 */
	@Test
	public void testConvertDecimalTo2sComp() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testNegative2sComp() {
		char data[] = {'1', '0', '1', '0', '0'};
		assertEquals(-12, Convert.convert2sCompToDecimal(data));
	}

}
