package com.devbrunorafael.tree;

//Esse código é uma contribuição de Mayank Jaiswal
class AVLTreeOFC {

    NodeOFC root;

    // Método que mede a altura da árvore
    int height(NodeOFC N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // Retorna o valor máximo entre dois inteiros
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Rotaciona para a direita a subárvore com raiz no nó y
    NodeOFC rightRotate(NodeOFC y) {
        NodeOFC x = y.left;
        NodeOFC T2 = x.right;

        // Executa a rotação
        x.right = y;
        y.left = T2;

        // Atualiza as alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Retorna a nova raiz
        return x;
    }

    // Rotaciona para a esquerda a subárvore com raiz no nó x
    NodeOFC leftRotate(NodeOFC x) {
        NodeOFC y = x.right;
        NodeOFC T2 = y.left;

        // Executa a rotação
        y.left = x;
        x.right = T2;

        //  Atualiza as alturas
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Retorna nova raiz
        return y;
    }

    // Obtém o fator de balanceamento do nó N
    int getBalance(NodeOFC N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    NodeOFC insert(NodeOFC nodeOFC, int key) {

        /* 1.  Inserção normal na Árvore Binária de Busca (BST) */
        if (nodeOFC == null)
            return (new NodeOFC(key));

        if (key < nodeOFC.key)
            nodeOFC.left = insert(nodeOFC.left, key);
        else if (key > nodeOFC.key)
            nodeOFC.right = insert(nodeOFC.right, key);
        else // Valores duplicados não são permitidos
            return nodeOFC;

        /* 2. Atualiza a altura do ancestral deste nó Update height of this ancestor node */
        nodeOFC.height = 1 + max(height(nodeOFC.left),
                height(nodeOFC.right));

        /* 3. Calcula Fator de Balanceamento */
        int balance = getBalance(nodeOFC);

        // Se o nó está desbalanceado, então faça:

        // Rotação à direita
        if (balance > 1 && key < nodeOFC.left.key)
            return rightRotate(nodeOFC);

        // Rotação à esquerda
        if (balance < -1 && key > nodeOFC.right.key)
            return leftRotate(nodeOFC);

        // Rotação LR
        if (balance > 1 && key > nodeOFC.left.key) {
            nodeOFC.left = leftRotate(nodeOFC.left);
            return rightRotate(nodeOFC);
        }

        // Rotação RL
        if (balance < -1 && key < nodeOFC.right.key) {
            nodeOFC.right = rightRotate(nodeOFC.right);
            return leftRotate(nodeOFC);
        }

        return nodeOFC;
    }

    // Exibe o percurso em pré-ordem
    // Também exibe a altura de cada nó
    void preOrder(NodeOFC nodeOFC) {
        if (nodeOFC != null) {
            System.out.print(nodeOFC.key + " ");
            preOrder(nodeOFC.left);
            preOrder(nodeOFC.right);
        }
    }

    public static void main(String[] args) {
        AVLTreeOFC tree = new AVLTreeOFC();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 60);

        /* A árvore AVL construida seria:
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Percurso em pré-ordem da árvore é:");
        tree.preOrder(tree.root);
    }
}
