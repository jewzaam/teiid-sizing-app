/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.jboss.teiid.sizing.util.validation;

import java.util.HashSet;
import java.util.Set;


public class SerializationValidation implements IValidation {

	Set<String> set = new HashSet<String>();

	public SerializationValidation(String... expecValue) {
		for (String str : expecValue) {
			set.add(str);
		}
	}
	
	public boolean isValid(String input) {
		if(isLong(input)){
			return true;
		}
		return set.contains(input);
	}
	
	public boolean isLong(String input) {

		Long result;

		try {
			result = Long.parseLong(input);
		} catch (NumberFormatException e) {
			return false;
		}

		if (result < 0) {
			return false;
		}
		return true;
	}

}
