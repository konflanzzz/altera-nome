import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class alterarNomeArquivo {
    public static void main(String[] args) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        String caminho_temp = "C:/Temp/";
        File diretorio_temp = new File(caminho_temp);
        if (!diretorio_temp.exists()) diretorio_temp.mkdirs();
        if (!caminho_temp.endsWith("\\")) caminho_temp += "\\";
        // String caminho_remessas = "C:/NSClientSuite/Remessas/";
        String caminho_remessas = "C:/Remessas/";
        File diretorio_remessas = new File(caminho_remessas);
        if (!diretorio_remessas.exists()) diretorio_remessas.mkdirs();
        if (!caminho_remessas.endsWith("\\")) caminho_remessas += "\\";
        Path directory = Paths.get("C:/Temp");
        WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                Path nomeArquivo = directory.resolve((Path) event.context());
                File antigo = nomeArquivo.toFile();
                String nomeAntigo = antigo.getName();
                String nomeNovo = nomeAntigo.replaceFirst("[.][^.]+$", "");
                if (nomeNovo.matches(".*\\d.*")) {
                    nomeNovo = ("NFEEMISSAO_" + nomeAntigo);
                }
                if (nomeNovo.matches("CANC")) {
                    nomeNovo = "NFECANC_.txt";
                }
                if (nomeNovo.matches("CCE")) {
                    nomeNovo = "NFECCE_.txt";
                }
                if (nomeNovo.matches("SITU")) {
                    nomeNovo = "NFESITUACAO_.txt";
                }
                if (nomeNovo.matches("MAIL")) {
                    nomeNovo = "NFEREENVIOEMAIL_.txt";
                }
                if (nomeNovo.matches("RIMP")) {
                    nomeNovo = "NFEREIMPRIME_.txt";
                }
                if (nomeNovo.matches("REVE")) {
                    nomeNovo = "NFEREIMPRIMEEVENTO_.txt";
                }
                if (nomeNovo.matches("PREV")) {
                    nomeNovo = "NFEPREVIA_.txt";
                }
                File novo = new File(caminho_remessas + nomeNovo);

                if (antigo.renameTo(novo)) {
                    System.exit(0);
                    System.out.println("O Arquivo foi renomeado");
                } else {
                    System.out.println("O Arquivo não foi renomeado");
                }
            }
        }
    }
}