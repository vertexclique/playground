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

package os;

public final class EPOCFile extends DOSFile
{
    // For use by this package

    EPOCFile(String path)
    {
        super(path);
    }

    EPOCFile(String directory, String file_name)
    {
        super(directory, file_name);
    }


    // For use by this class

    protected String[] logical_drives()
    {
        if (_logical_drives == null)
        {
            boolean[] drives = new boolean[26];
            for (char drive_letter = 'c'; 
                 drive_letter <= 'z'; 
                 drive_letter++)
                drives[drive_letter - 'c'] = false;
            int n_drives = 0;
            for (char drive_letter = 'c';
                 drive_letter <= 'z';
                 drive_letter++)
            {
                java.io.File logical_drive = 
                    new java.io.File(drive_letter + ":\\system");
                if (logical_drive.exists())
                {
                    drives[drive_letter - 'c'] = true;
                    n_drives++;
                }
            }
            _logical_drives = new String[n_drives];
            int i = 0;
            for (char drive_letter = 'c'; 
                 drive_letter <= 'z';
                 drive_letter++)
                if (drives[drive_letter - 'c'])
                    _logical_drives[i++] = 
                        new String(new char[] { drive_letter });
        }
        return _logical_drives;
    }
}
