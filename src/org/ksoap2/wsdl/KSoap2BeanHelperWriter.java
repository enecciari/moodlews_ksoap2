/*
 * Copyright 2011 Patrick Pollet 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ksoap2.wsdl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.Vector;

import org.apache.axis.Constants;
import org.apache.axis.wsdl.symbolTable.ElementDecl;
import org.apache.axis.wsdl.symbolTable.TypeEntry;
import org.apache.axis.wsdl.toJava.Emitter;
import org.apache.axis.wsdl.toJava.JavaBeanHelperWriter;
import org.apache.axis.wsdl.toJava.Utils;

public class KSoap2BeanHelperWriter extends JavaBeanHelperWriter{

	
	
	protected KSoap2BeanHelperWriter(Emitter emitter, TypeEntry type,
			Vector elements, TypeEntry extendType, Vector attributes,
			Set reservedPropNames) {
		super(emitter, type, elements, extendType, attributes, reservedPropNames);
		// TODO Auto-generated constructor stub
		
		
	}
	
	
    protected void writeMetaData (PrintWriter pw) throws IOException {
    }
    
    protected void writeSerializer (PrintWriter pw) throws IOException {
    }
    
    protected void writeDeserializer (PrintWriter pw) throws IOException {
    }
    
    public String getQNameLocalPart(String elementName)
    {
    	
    	if (elements != null) {
		 	            for (int i = 0; i < elements.size(); i++) {
		 	                ElementDecl elem = (ElementDecl) elements.get(i);
		 	                String variableName;
		 	
		                 if (elem.getAnyElement()) {
		 	                    variableName = Constants.ANYCONTENT;
		 	                } else {
		 	                    variableName = elem.getName();
		 	                }
		 	

		 	                if (variableName.equals(elementName))
		 	                    return Utils.getLastLocalPart(elem.getQName().getLocalPart());
		 	            }
		 	    }
    	
		return null;
    	
    }

}
