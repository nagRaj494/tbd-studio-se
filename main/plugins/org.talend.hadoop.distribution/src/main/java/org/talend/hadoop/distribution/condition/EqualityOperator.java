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
package org.talend.hadoop.distribution.condition;

public enum EqualityOperator {
    EQ("=="), //$NON-NLS-1$
    NOT_EQ("!="); //$NON-NLS-1$

    private String mSymbol;

    EqualityOperator(String symbol) {
        this.mSymbol = symbol;
    }

    public String getSymbol() {
        return this.mSymbol;
    }
}
