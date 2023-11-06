/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.pkix1implicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;

import com.gsma.sgp.messages.pkix1explicit88.Attribute;
import com.gsma.sgp.messages.pkix1explicit88.CertificateSerialNumber;
import com.gsma.sgp.messages.pkix1explicit88.DirectoryString;
import com.gsma.sgp.messages.pkix1explicit88.Name;
import com.gsma.sgp.messages.pkix1explicit88.ORAddress;
import com.gsma.sgp.messages.pkix1explicit88.RelativeDistinguishedName;

public class PolicyQualifierInfo implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private PolicyQualifierId policyQualifierId = null;
	private BerAny qualifier = null;
	
	public PolicyQualifierInfo() {
	}

	public PolicyQualifierInfo(byte[] code) {
		this.code = code;
	}

	public void setPolicyQualifierId(PolicyQualifierId policyQualifierId) {
		this.policyQualifierId = policyQualifierId;
	}

	public PolicyQualifierId getPolicyQualifierId() {
		return policyQualifierId;
	}

	public void setQualifier(BerAny qualifier) {
		this.qualifier = qualifier;
	}

	public BerAny getQualifier() {
		return qualifier;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += qualifier.encode(reverseOS);
		
		codeLength += policyQualifierId.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(PolicyQualifierId.tag)) {
			policyQualifierId = new PolicyQualifierId();
			subCodeLength += policyQualifierId.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		qualifier = new BerAny();
		subCodeLength += qualifier.decode(is, berTag);
		if (subCodeLength == totalLength) {
			return codeLength;
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (policyQualifierId != null) {
			sb.append("policyQualifierId: ").append(policyQualifierId);
		}
		else {
			sb.append("policyQualifierId: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (qualifier != null) {
			sb.append("qualifier: ").append(qualifier);
		}
		else {
			sb.append("qualifier: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}
