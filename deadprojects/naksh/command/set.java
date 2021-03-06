// Naksh
// Copyright (C) 2011 Mahmut Bulut
// 
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License as
// published by the Free Software Foundation; either version 2 of
// the License, or (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
// 02111-1307, USA.
// 
// Mahmut Bulut  mahmutbulut0@gmail.com

package command;

import java.io.*;
import naksh.*;
import commandline.Variable;

public class set extends Command
{
    public void execute(String[] args)
    {
        String var = args[0];
        // Try creating the variable to validate the variable
        // name.
        Variable.create('$' + var);
        if (args.length == 1)
            removeProperty(var);
        else
        {
            String value = args[1];
            property(var, value);
            out().println(var+"="+value);
        }
    }

    public void usage()
    {
        out().println("set variable [value]");
        out().println("    If a value is specified, then the variable's\n"+
                      "    value is set to the specified value. Otherwise,\n"+
                      "    the variable is removed.");
    }
}
