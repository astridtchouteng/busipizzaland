INSERT INTO public.categorie(categorie) VALUES ('VEGETARIENNE');
INSERT INTO public.categorie(categorie) VALUES ('FROMAGE');
INSERT INTO public.categorie(categorie) VALUES ('EXOTIQUE');
INSERT INTO public.categorie(categorie) VALUES ('CUSTOMISEE');

INSERT INTO public.etatcommande(etat) VALUES ('ROLE_USER');
INSERT INTO public.etatcommande(etat) VALUES ('ROLE_ADMIN');

INSERT INTO public.ingredient(nom, stock)
	VALUES ('Fromage', 15);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Ognons', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Mazarella', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Tomate', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Olive', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Jambon', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Champignon', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Lardon', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Ananas', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Aubergine', 10);
INSERT INTO public.ingredient(nom, stock)
	VALUES ('Courgette', 10);
	
	INSERT INTO public.pizza( description, nom, prix, categorie)
	VALUES ('La pizza hawaïenne est une variété de pizza qui se compose généralement de fromage et d une base de tomate avec des morceaux de jambon et d ananas',
		    'Pizza Hawaienne',12.5,1);
INSERT INTO public.pizza( description, nom, prix, categorie)
	VALUES ('',
		    'Pizza Maurine',6,1);
INSERT INTO public.pizza( description, nom, prix, categorie)
	VALUES ('',
		    'Legumes de l ete',7.5,2);
INSERT INTO public.pizza( description, nom, prix, categorie)
	VALUES ('',
		    'Quatres fromages',8,2);
INSERT INTO public.pizza( description, nom, prix, categorie)
	VALUES ('',
		    'Roulée aux légumes',8,3);
			
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (1,1,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (1,2,2);
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (1,3,2);
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (2,1,2);
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (2,2,2);
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (2,3,2);
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (2,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (3,1,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (3,2,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (3,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (7,3,2);	
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (7,2,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (7,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (7,3,2);	
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (8,2,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (8,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (8,3,2);	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (9,2,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (9,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (9,3,2);	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (10,2,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (10,4,2);
	
INSERT INTO public.portion(
	ingredient_id, pizza_id, portion)
	VALUES (10,3,2);	

	INSERT INTO public.etatcommande( etat)
	VALUES ('NON_PAYE');
INSERT INTO public.etatcommande( etat)
	VALUES ('NON_PAYE');
INSERT INTO public.etatcommande( etat)
	VALUES ('LIVRAISON');
INSERT INTO public.etatcommande( etat)
	VALUES ('PREPARATION');
	

