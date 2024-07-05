# Binary Search Tree (BST) Project

This project implements a Binary Search Tree (BST) and a Dictionary using BST in Java. The project includes various classes to support the creation, manipulation, and utilization of BSTs.

## Table of Contents

- [Introduction](#introduction)
- [Classes](#classes)
- [Usage](#usage)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

A Binary Search Tree (BST) is a node-based binary tree data structure in which each node has at most two children, referred to as the left child and the right child. For each node, the left subtree contains only nodes with keys less than the node’s key, and the right subtree only nodes with keys greater than the node’s key.

This project provides a set of classes that implement the BST and a Dictionary using the BST.

## Classes

### `BinarySearchTree.java`

This class implements the basic functionality of a Binary Search Tree, including insertion, deletion, and searching of nodes.

### `BSTDictionary.java`

This class implements a Dictionary ADT using a Binary Search Tree as the underlying data structure. It supports operations such as insertion, deletion, and lookup of key-value pairs.

### `BSTDictionaryADT.java`

An abstract data type (ADT) interface that defines the operations supported by the BSTDictionary.

### `BSTNode.java`

This class represents a node in the Binary Search Tree. Each node contains a key, value, and references to the left and right child nodes.

### `Interface.java`

An interface defining the basic operations of the BST, including insertion, deletion, and searching.

### `Key.java`

A class representing the key used in the BST and Dictionary. This can be customized based on the type of keys used in your application.

## Usage

To use the BST and Dictionary in your application, follow these steps:

1. **Initialize the BST or Dictionary:**

    ```java
    BinarySearchTree bst = new BinarySearchTree();
    BSTDictionary dictionary = new BSTDictionary();
    ```

2. **Insert elements into the BST or Dictionary:**

    ```java
    bst.insert(new BSTNode(key, value));
    dictionary.insert(key, value);
    ```

3. **Search for elements:**

    ```java
    BSTNode result = bst.search(key);
    Value value = dictionary.lookup(key);
    ```

4. **Delete elements:**

    ```java
    bst.delete(key);
    dictionary.delete(key);
    ```

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/bst-project.git
    ```

2. Compile the Java files:

    ```bash
    javac BinarySearchTree.java BSTDictionary.java BSTDictionaryADT.java BSTNode.java Interface.java Key.java
    ```

3. Run the application:

    ```bash
    java YourMainClass
    ```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request if you have any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
