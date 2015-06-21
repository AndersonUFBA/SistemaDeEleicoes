# SistemaDeEleicoes
Sistema de Eleição da UFBA (SEUFBA)
Para que o sistema funcione você deverá ter em seu computador:

1- Eclipse com pespectiva Java EE;
2- apache-tomcat-6.0.35 em diante;
3- salvar na lib do apache-tomcat os segintes .jar, que se encontram WEB-INF/lib (basta copiar e colar) :
	a)common-annotations
	b)antlr-2.7.6
	c)commons-beanutils
	d)commons-collections
	e)commons-digester
	f)commons-logging
	g)dom4j-1.6.1
	h)hibernate3
	i)hibernate-jpa-2.0-api-1.0.1.Final
	j)javassist-3.12.0.GA
	k)jsf-impl
	l)jsf-api
	m)jsf-tlds
	n)jta-1.1
	o)mysql-connector-java-5.1.8-bin
	p)slf4j-api-1.6.4
	q)slf4j-simple-1.6.4
4-criar um database no mysql com o nome "seufba", sem tabelas, pois o hibernate irá criar para você.
OBS.: altere a senha do seu SGBD no arquivo hibernate.cfg.mxl, pois a senha que está salva é r@@t e o usuario root
6- ter o java jdk1.6.0_45 em diante;

Pronto! o sistema estará funcionando.