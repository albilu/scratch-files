package org.netbeans.scratchfiles;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openide.filesystems.FileUtil;
import org.openide.util.Utilities;

/**
 *
 * @author bilu
 */
public class ScratchFilesFolder {

	public static URL getScratchFilesFolder() throws MalformedURLException {
		String s = System.getProperty("netbeans.user")
				+ File.separator + "ScratchFiles";
		File userDir = new File(s);
		if (!userDir.exists()) {
			userDir.mkdirs();
		}
		userDir = FileUtil.normalizeFile(userDir);
		return Utilities.toURI(userDir).toURL();
	}

}
