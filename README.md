# tarification

Le projet met en place un model flexible qui implémente les différents schémas de tarification présentés dans l'exercie,
et est capable de recevoir assez facilement d'autres schémas de tarification. pour le faire il faut:

- Etendre le model de base des tarifications et définir les propriétés en plus du nouveau schéma qu'on veut ajouter.
- Ajouter le type de tarification à l'énumération qui défini les différents type de tarification utilisés par le model.
- Implémenter le generateur de tarification qui fixe le prix du produit selon la nouvelle tarification pour cette tarification. Puis l'ajouter à la factory qui le fournira
 lorsqu'on voudra fixer le prix du produit en utilisant cette tarification.
