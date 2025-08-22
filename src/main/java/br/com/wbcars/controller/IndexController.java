package br.com.wbcars.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IndexController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String message = "Bem-vindo ao Sistema WB Cars!";
    private String inputText = "";
    private String selectedOption = "";
    private List<Car> cars;
    private Car selectedCar;
    
    public IndexController() {
        initializeCars();
    }
    
    private void initializeCars() {
        cars = new ArrayList<>();
        cars.add(new Car(1, "Honda Civic", "Honda", 2023, "Prata", 85000.0, "Disponível"));
        cars.add(new Car(2, "Toyota Corolla", "Toyota", 2022, "Branco", 78000.0, "Vendido"));
        cars.add(new Car(3, "Ford Ka", "Ford", 2021, "Azul", 55000.0, "Disponível"));
        cars.add(new Car(4, "Chevrolet Onix", "Chevrolet", 2023, "Preto", 62000.0, "Reservado"));
        cars.add(new Car(5, "Volkswagen Polo", "VW", 2022, "Vermelho", 72000.0, "Disponível"));
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getInputText() {
        return inputText;
    }
    
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
    
    public String getSelectedOption() {
        return selectedOption;
    }
    
    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    public Car getSelectedCar() {
        return selectedCar;
    }
    
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    
    public String inicializar() {
        System.out.println("IndexController inicializado com sucesso!");
        message = "Sistema inicializado às " + new java.util.Date();
        return null;
    }
    
    public void showMessage() {
        System.out.println("Botão clicado! Input: " + inputText);
    }
    
    public void addCar() {
        int newId = cars.size() + 1;
        cars.add(new Car(newId, "Novo Carro " + newId, "Marca", 2024, "Cor", 50000.0, "Disponível"));
        System.out.println("Novo carro adicionado!");
    }
    
    public void deleteCar() {
        if (selectedCar != null) {
            cars.remove(selectedCar);
            selectedCar = null;
            System.out.println("Carro removido!");
        }
    }
    
    // Classe interna Car
    public static class Car implements Serializable {
        private int id;
        private String modelo;
        private String marca;
        private int ano;
        private String cor;
        private Double preco;
        private String status;
        
        public Car() {}
        
        public Car(int id, String modelo, String marca, int ano, String cor, Double preco, String status) {
            this.id = id;
            this.modelo = modelo;
            this.marca = marca;
            this.ano = ano;
            this.cor = cor;
            this.preco = preco;
            this.status = status;
        }
        
        // Getters e Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        
        public String getModelo() { return modelo; }
        public void setModelo(String modelo) { this.modelo = modelo; }
        
        public String getMarca() { return marca; }
        public void setMarca(String marca) { this.marca = marca; }
        
        public int getAno() { return ano; }
        public void setAno(int ano) { this.ano = ano; }
        
        public String getCor() { return cor; }
        public void setCor(String cor) { this.cor = cor; }
        
        public Double getPreco() { return preco; }
        public void setPreco(Double preco) { this.preco = preco; }
        
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
