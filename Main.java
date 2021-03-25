import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Main {
    public static void main(String[] args) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path directory = Paths.get("C:/Users/fernando.konflanz/Desktop/arquivos/Temp");
        WatchKey watchKey = directory.register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                //System.out.println(event.kind()); //if entry event get file name?
                Path nomeArquivo = directory.resolve((Path) event.context());
                File antigo = nomeArquivo.toFile();
                String nomeAntigo = antigo.getName();
                String nomeNovo = nomeAntigo.replaceFirst("[.][^.]+$", "");
                nomeNovo = ("NFEEMISSAO_" + nomeAntigo);
                System.out.println(nomeNovo);
                File novo = new File("Remessas/" + nomeNovo);
                if (antigo.renameTo(novo)) {
                    System.out.println("O arquivo foi renomeado com sucesso e enviado para a pasta Remessas");
                } else {
                    System.out.println("O Arquivo não foi renomeado");
                }
            }
        }
    }
}