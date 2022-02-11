package c04.composite.designed;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {
    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int num = 0;
        for (FileSystemNode subNode : subNodes) {
            num += subNode.countNumOfFiles();
        }
        return num;
    }

    @Override
    public long countSizeOfFiles() {
        long size = 0;
        for (FileSystemNode subNode : subNodes) {
            size += subNode.countSizeOfFiles();
        }
        return size;
    }

    public void addSub(FileSystemNode fileSystemNode) {
        subNodes.add(fileSystemNode);
    }

    public void remove(FileSystemNode fileSystemNode) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).path.equalsIgnoreCase(fileSystemNode.path)) {
                break;
            }
        }
        subNodes.remove(i);
    }
}
