Tarefa - Criar um documento XML usando Java (DOM)

Considere o documento XML abaixo (um RSS utilizado para recuperar not�cias).

- Crie uma classe Item (representa a tag <item> e seus elementos filhos)

- Crie uma classe RSSCanal com um m�todo adicionarItem(Item item) para adicionar v�rios objetos da classe Item. Nessa mesma classe, crie o m�todo imprimir(), que deve imprimir no terminal e em um arquivo um XML como o abaixo, considerando todos os objetos Item adicionados.

- No m�todo main(), mostre a utiliza��o da classe RSSCanal.

- Envie um zip com os dois arquivos .java necess�rios.

<?xml version="1.0"?>
<rss version="2.0">
<channel>
<title>Example Channel</title>

<link>http://example.com/</link>
<description>My example channel</description>
<item>
<title>News for September the Second</title>

<link>http://example.com/2002/09/01</link>
<description>other things happened today</description>
</item>
<item>
<title>News for September the First</title>

<link>http://example.com/2002/09/02</link>
</item>
</channel>
</rss>