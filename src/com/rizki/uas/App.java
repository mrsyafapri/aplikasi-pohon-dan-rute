package com.rizki.uas;

import java.util.Scanner;

/**
 *
 * @author Muhammad Rizki Syafapri <12050110483>
 */
public class App {

    public static void runBinary() {
        int value;
        String data;
        BinaryTree tree = new BinaryTree();
        tree.insert(23, "Rosa");
        tree.insert(78, "Raisa");
        tree.insert(15, "Naya");
        tree.insert(38, "Gagas");
        tree.insert(50, "Ahmad");
        tree.insert(48, "Ainun");
        tree.insert(30, "Beri");
        tree.insert(35, "Vivid");
        tree.insert(85, "Orin");
        tree.insert(90, "Wiwid");
        tree.insert(98, "Sasa");
        boolean kondisi = true;

        while (kondisi) {
            System.out.println("\nPohon Menggunakan Binary Tree");
            System.out.println("Pilih Menu di bawah ini");
            System.out.println("1. Menampilkan Pohon");
            System.out.println("2. Menambahkan(insert) value dan data");
            System.out.println("3. Mencari(find) value");
            System.out.println("4. Menghapus(delete) value");
            System.out.println("5. Traverse");
            System.out.println("6. Maximum Value");
            System.out.println("7. Minimum Value");
            System.out.println("8. Keluar");
            System.out.print("Masukkan pilihan Anda (1-8): ");
            int choice = getInt();
            switch (choice) {
                case 1:
                    tree.displayTree();
                    break;
                case 2:
                    System.out.print("Enter value and data to insert: ");
                    value = getInt();
                    data = getString();
                    tree.insert(value, data);
                    break;
                case 3:
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = tree.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Could not delete " + value);
                    }
                    break;
                case 5:
                    System.out.println("1. Preorder traversal: ");
                    System.out.println("2. Inorder traversal: ");
                    System.out.println("3. Postorder traversal: ");
                    System.out.print("Enter type 1/2/3: ");
                    value = getInt();
                    tree.traverse(value);
                    break;
                case 6:
                    int max = tree.findMax(tree.getRoot());
                    System.out.println("Maximum value = " + max);
                    break;
                case 7:
                    int min = tree.findMin(tree.getRoot());
                    System.out.println("Minimum value = " + min);
                    break;
                case 8:
                    System.out.println("- Keluar dari menu BINARY TREE -");
                    kondisi = false;
                    break;
                default:
                    System.out.println("=== Mohon maaf menu tidak tersedia ===");
                    System.out.println("- Input menu harus diantara 1 sampai 8 -");
                    break;
            }
        }
    }

    public static void runGraph() {
        System.out.println("\nPenentuan Rute Menggunakan GRAPH");
        System.out.println("Membuat GRAPH");
        System.out.print("Masukkan nilai vertices(panjang): ");
        int vertices = getInt();
        System.out.print("Masukkan banyak edges(rute): ");
        int edges = getInt();
        Graph graph = new Graph(vertices, edges);
        for (int i = 0; i < edges; i++) {
            System.out.print("Masukkan nilai asal: ");
            int src = getInt();
            System.out.print("Masukkan nilai tujuan: ");
            int dest = getInt();
            graph.addEdge(src, dest);
            System.out.println();
        }

        boolean kondisi = true;
        while (kondisi) {
            System.out.println("\nPilih Menu di bawah ini");
            System.out.println("1. Menampilkan Info Graph");
            System.out.println("2. Mencari Rute/Jalur");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda (1-3): ");
            int choice = getInt();

            switch (choice) {
                case 1:
                    graph.getVertices();
                    graph.getEdges();
                    System.out.println(graph.toString());
                    break;
                case 2:
                    System.out.print("Masukkan asal angka yang ingin Anda cari: ");
                    int source = getInt();
                    System.out.print("Masukkan tujuan angka yang ingin Anda cari: ");
                    int destination = getInt();
                    System.out.println("Berikut ini adalah semua jalur yang berbeda dari " + source + " ke " + destination);
                    graph.printAllPaths(source, destination);
                    int jumlahJalur = graph.countPaths(source, destination);
                    System.out.println("Jumlah jalur = " + jumlahJalur);
                    break;
                case 3:
                    System.out.println("- Keluar dari menu Penentuan Rute Menggunakan GRAPH -");
                    kondisi = false;
                    break;
                default:
                    System.out.println("=== Mohon maaf menu tidak tersedia ===");
                    System.out.println("- Input menu harus diantara 1 sampai 3 -");
                    break;
            }
        }
    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public static int getInt() {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================== Selamat Datang =====================");
        System.out.println("Aplikasi Pohon menggunakan BINARY TREE dan Penentuan Rute menggunakan GRAPH");
        System.out.println("Oleh Muhammad Rizki Syafapri (12050110483)");
        boolean kondisi = true;
        while (kondisi) {
            System.out.println();
            System.out.println("Pilih MENU UTAMA di bawah ini:");
            System.out.println("1. Pohon menggunakan Binary Tree");
            System.out.println("2. Penentuan Rute menggunakan GRAPH");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan Anda (1/2/3) : ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    App.runBinary();
                    break;
                case 2:
                    App.runGraph();
                    break;
                case 3:
                    System.out.println("============== Keluar Program ==============");
                    kondisi = false;
                    break;
                default:
                    System.out.println("=== Mohon maaf menu tidak tersedia ===");
                    System.out.println("- Input MENU UTAMA harus diantara 1 sampai 3 -");
                    break;
            }
        }
    }
}
