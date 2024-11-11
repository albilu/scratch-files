package org.netbeans.scratchfiles;

import java.util.ArrayList;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Chrizzly
 */
@ServiceProvider(service = MimeTypeQueryImpl.class, position = 10)
public final class MimeTypeQueryImpl {

	public static String getMimeType(FileObject file) {
		assert file != null;

		return file.getMIMEType();
	}

	public static List<String> getMimeTypes() {
		FileObject[] children = FileUtil.getConfigFile("Loaders").getChildren();
		List<String> mimeTypes = new ArrayList<>();

		for (FileObject child : children) {
			FileObject[] subchildren = child.getChildren();

			for (FileObject subchild : subchildren) {
				FileObject factoriesFO = subchild.getFileObject("Factories");

				if (factoriesFO != null && factoriesFO.getChildren().length > 0) {
					// add only MIME types where some loader exists
					// beter filtering by @bilu
					String ext = subchild.getNameExt().replaceFirst("x-", "");
					if (!ext.contains("-") && !ext.contains("+")) {
						switch (ext) {
							case "typescript":
								mimeTypes.add("ts");
								mimeTypes.add("tsx");
								break;
							case "python":
								mimeTypes.add("py");
								break;
							case "javascript":
								mimeTypes.add("js");
								break;
							case "javacc":
								mimeTypes.add("jj");
								break;
							case "fortran":
								mimeTypes.add("for");
								break;
							case "kotlin":
								mimeTypes.add("kt");
								mimeTypes.add("kts");
								mimeTypes.add("ktm");
								break;
							case "manifest":
								mimeTypes.add("mf");
								break;
							default:
								mimeTypes.add(ext);
						}
					}
				}
			}
		}

		mimeTypes.remove("unknown");

		return mimeTypes;
	}
}
