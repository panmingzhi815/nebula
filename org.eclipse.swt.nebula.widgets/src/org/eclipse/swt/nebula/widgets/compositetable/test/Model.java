/*
 * Copyright (C) 2005 David Orme <djo@coconut-palm-software.com>
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Orme     - Initial API and implementation
 */
package org.eclipse.swt.nebula.widgets.compositetable.test;

import java.util.LinkedList;

import org.eclipse.swt.nebula.widgets.compositetable.IDeleteHandler;
import org.eclipse.swt.nebula.widgets.compositetable.IInsertHandler;

public class Model {
	public Model() {
		// Add some sample data to our personList...
//		personList.add(new Person("John", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Jane", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Frank", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Joe", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Chet", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Wilbur", "1234", "Wheaton", "IL"));
//		personList.add(new Person("Elmo", "1234", "Wheaton", "IL"));
	}

	// Now a PersonList property...
	
	LinkedList personList = new LinkedList();
	
	public LinkedList getPersonList() {
		return personList;
	}

	public IDeleteHandler getPersonListDeleteHandler() {
		return new IDeleteHandler() {
			public boolean canDelete(int rowInCollection) {
				return true;
			}

			public void deleteRow(int rowInCollection) {
				personList.remove(rowInCollection);
			}
		};
	}
	
	public IInsertHandler getPersonListInsertHandler() {
		return new IInsertHandler() {
			public int insert(int positionHint) {
				Person newPerson = new Person();
				personList.add(positionHint, newPerson);
				return positionHint;
				// int newPosition = (int)(Math.random() *
				// (personList.size()+1));
				// personList.add(newPosition, newPerson);
				// return newPosition;
			}
		};
	}
}