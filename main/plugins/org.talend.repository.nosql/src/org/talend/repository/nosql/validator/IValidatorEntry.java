// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.nosql.validator;

/**
 * created by ycbai on Jul 23, 2014 Detailled comment
 * 
 */
public interface IValidatorEntry {

    public boolean doValidate();

    public String getFailMsg();

    public String getSuccessfulMsg();

}
