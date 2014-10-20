/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ArithmetricExprConversion.java
 *         Created:   Oct 19, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:     +   ->  1 + 2
 *                     / \
 *                    1   2
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

import util.StringNode;

public class ArithmetricExprConversion {
    public String convert(StringNode root) {
        StringBuffer sb = new StringBuffer();
        convert(root, sb);
        return root == null ? null : sb.toString();
    }

    public void convert(StringNode root, StringBuffer sb) {
        if (root == null)
            return;
        if (root.val.matches("[-+*/]")) {
            sb.append("(");
            convert(root.left, sb);
            sb.append(root.val);
            convert(root.right, sb);
            sb.append(")");
        } else {
            sb.append(root.val);
        }
    }
}
