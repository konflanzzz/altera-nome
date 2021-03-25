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

        // Define o caminho para a pasta temporária

        String caminho_temp = "C:/Temp/"; 

        // Verifica se existe o diretório, e caso não exista, adicionará ele no caminho.

        File diretorio_temp = new File(caminho_temp);
        if (!diretorio_temp.exists()) diretorio_temp.mkdirs();
        if (!caminho_temp.endsWith("\\")) caminho_temp += "\\";

        // Define o caminho da pasta Remessas do Client Suite


        // String caminho_remessas = "C:/NSClientSuite/Remessas/";
        String caminho_remessas = "C:/Remessas/";
        File diretorio_remessas = new File(caminho_remessas);
        if (!diretorio_remessas.exists()) diretorio_remessas.mkdirs();
        if (!caminho_remessas.endsWith("\\")) caminho_remessas += "\\";

        

        // Observa a pasta na espera de um evento

        Path directory = Paths.get("C:/Temp");
        WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {

                // Captura o caminho do documento
                Path nomeArquivo = directory.resolve((Path) event.context());

                File antigo = nomeArquivo.toFile();

                // Cria uma variável com o nome do documento para poder trabalhar com ela
                String nomeAntigo = antigo.getName();


                // Remove a extensao para pegar o numero da nota
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
                    System.out.println("O arquivo foi renomeado com sucesso e enviado para a pasta Remessas");
                    System.out.println(nomeNovo);
                } else {
                    System.out.println("O Arquivo não foi renomeado");
                }
            }
        }
    }
}