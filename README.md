# altera-nome

Este arquivo contem uma classe em Java e também um .jar, para que executar testes com a linguagem Clipper, que fará a renomeação dos arquivos gerados por uma aplicação Clipper, fazendo com que se adequem ao padrao de nomenclatura do Client Suite, o que facilitará tua integração e migração para nossa nova plataforma.

Este arquivo ainda não está finalizado, e precisam ser ajustados alguns pontos, e a finalidade dele, considerando que ele já esta executando a tarefa de renomear arquivos, é somente para testes.

No momento, o arquivo tem a função de gerar duas pastas do diretório raiz (C:/): a pasta “Temp” e a pasta “Remessas”

O Script será executado e ficará em espera de algum evento na pasta “Temp”. No momento que esta pasta receber os arquivos, ela fará o envio para a pasta “Remessas” criada, alterando a nomenclatura do arquivo .txt.

O endereçamento desta pasta Remessas, após os teus testes, será direcionada para a pasta Remessas dentro da Estrutura do Client Suite. Neste momento, apenas está simulando como seria uma operação normal.

É importante seguir o seguinte padrão de nome de arquivos:

- 1234 ( somente dígitos ) para a emissão, e será renomeado para NFEEMISSAO_1234 
( manetendo o numero da NFe gerada. )

- CANC para cancelamento de nota fiscal, e será renomeado para NFECANC_

- CCE para carta de correção da nota fiscal, e será renomeado para NFECCE_

- MAIL para agendar o re-envio de email, e será renomeado para NFEREENVIOEMAIL_

- PREV para gerar uma prévia da DANFE, e será renomeado para NFEPREVIA_

- REVE para gerar a reimpressao de um evento da NFe, e será renomeado para NFEREIMPRIMEEVENTO_

- RIMP para gerar a reimpressao da DANFE de uma NFe autorizada, e será renomeado para NFEREIMPRIME_

- SITU para consultar a situação da NFe autorizada, e será renomeado para NFESITUACAO_

Neste momento, para encerrar os testes, deverá ser finalizada a tarefa do Java no Gerenciador de Tarefas.

Por hora, esta solução, é apenas para testes. A fim de verificarmos se é possivel com  Clipper tirarmos proveito desse desenvolvimento em Java.

Dentro das pastas, poderá ser utilizado tanto do Main.Java, contendo a classe, e que pode servir como lib para o código, como também, poderá ser encontrado o .jar para executá-lo, independendo da aplicação.

Peço que, durante e depois dos testes mantenha contato conosco, para acompanharmos e analisarmos a execução do código e, caso seja necessário, implementarmos novas funcionalidades ou corrigir as dificuldades encontradas.
