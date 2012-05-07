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

package naksh;

import java.io.*;
import os.*;

public abstract class OS
{
    public static OS create()
    {
        String os_name = System.getProperty("os.name");
        OS os = null;
        if (os_name.toLowerCase().indexOf("windows") >= 0)
            os = new DOS();
        else if (os_name.toLowerCase().indexOf("epoc") >= 0)
            os = new EPOC();
        else
            os = new UNIX();
        return os;
    }

    public abstract boolean caseSensitive();

    public abstract String nakshToOsPath(String naksh_path);

    public abstract String osToJshellPath(String os_path);

    public abstract String canonicalizePath(String path)
        throws IOException;

    public abstract naksh.File createFile(String path);

    public abstract naksh.File createFile(String directory, 
                                           String file_name);
}
