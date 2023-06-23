# PUCRS - Trabalho Final
Trabalho final do 1º semestre referente a matéria Fundamentos de Programação, do curso Sistemas de Informação.

Neste projeto buscamos ir um pouco além das lições aprendidas em aula. No início, nossa ideia era terminar este projeto com prevenção de erros do usuário, dados salvos de forma dinâmica e uma interface. Conseguimos alcançar 2 destes objetivos... Nosso código conta com diversas validações de dados de entrada para prever valores inválidos informados pelo usuário, e também conta com dados sendo salvos e carregados de forma dinâmica através de um arquivo .txt, utilizando como intermédio uma API, interface utilizada em praticamente todas aplicações reais.


## Fontes usadas
- ChatGPT (Para aprender tópicos ainda não abordados na matéria)


## Lições aprendidas
- Maior compreensão sobre POO
- Entendimento prático do modificador "static"
- Criação dinâmica de diretórios 
- Manipulação de TXT com algoritmos
- Utilização do ArrayList
- Tratamento de erros com "try" e "catch"
- Tratamentos de dados usando funções métodos prontos para string
- Transformação de dados do tipos string para outros tipos de dados
- Automação de processos, como entrada de dados, através de loopings e matrizes


## Dificuldades encontradas
1 - Manipulação de arquivos. Já tinha trabalhado com modificação de .txt antes, porém,
não com Java, então busquei ensinamentos sobre isso com o ChatGPT, ferramenta que costumo usar
para aprender um novo tópico.

2 - Criação de arquivos. Tivemos problemas com a criação dinâmica do arquivo .txt, então para 
resolver fizemos debug no código e adicionamos uma validação que cria o arquivo, caso ele não exista.

3 - Identificação de erros. Muitas vezes alguns métodos acabavam ficando extensos, um erro com uma variável com valor null, ou tipo de dado diferente, acaba sendo mais complexo de ser percebido.

4 - Evitar erros de entrada. Nossa ideia era evitar o erro do usuário ao informar as opções no programa, porém me senti um pouco limitado por questão da baixa variabilidade dos tipos da linguagem java.

5 - Testes de um método específico. Com o desenvolver do programa, ele acabou ficando com muitos métodos, porém, tivemos dificuldades para testa-los separadamente, sem precisar reiniciar  todo o programa, cadastrar pacientes e etc.