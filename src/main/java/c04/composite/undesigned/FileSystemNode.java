package c04.composite.undesigned;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSystemNode {
    private final List<FileSystemNode> subNodes = new ArrayList<>();
    private String path;
    private boolean isFile;

    public String getPath() {
        return path;
    }


    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    /**
     * 文件/夹文件总个数
     */
    public int countNumOfFiles() {
        if (isFile) return 1;
        int num = 0;
        for (FileSystemNode subNode : subNodes) {
            num += subNode.countNumOfFiles();
        }
        return num;
    }

    /**
     * 文件/夹总大小
     */
    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            return file.length();
        }
        long fileSize = 0;
        for (FileSystemNode subNode : subNodes) {
            fileSize += subNode.countSizeOfFiles();
        }
        return fileSize;
    }

    public void addSubNode(FileSystemNode fileSystemNode) {
        subNodes.add(fileSystemNode);
    }


    public void removeSubNode(FileSystemNode fileSystemNode) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileSystemNode.getPath())) {
                break;
            }
        }
        subNodes.remove(i);
    }
}
