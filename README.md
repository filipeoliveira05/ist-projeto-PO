# PO 24/25 - Projeto
**Filipe Oliveira**  
**Número de estudante**: ist1110633

## 📌 Descrição do Projeto  

Este projeto consiste no desenvolvimento de uma **aplicação de gestão de um hotel veterinário** que inclui tratadores, veterinários e habitats com árvores.  

A aplicação permite a **gestão de animais, funcionários, habitats e vacinas**, garantindo que todas as operações essenciais são suportadas. Além disso, permite **calcular a satisfação dos animais e funcionários**, acompanhar o histórico de vacinações, entre outras funcionalidades.

---

## 🎯 Funcionalidade da Aplicação  

O sistema gerencia as seguintes entidades principais:  

### 🦁 **Animais**  
- Identificados por um **ID único** e pertencem a uma **espécie específica**.  
- Possuem um **histórico de vacinação** e um estado de **satisfação**, que é calculado com base no habitat e nos animais vizinhos.  

### 🌳 **Habitats**  
- Estruturas que acomodam animais e podem conter **árvores**.  
- Cada habitat pode ter uma **influência positiva, negativa ou neutra** sobre certas espécies.  

### 👩‍⚕️ **Funcionários**  
- **Veterinários** são responsáveis por vacinar animais.  
- **Tratadores** cuidam da limpeza e alimentação dos habitats.  
- A satisfação dos funcionários depende da carga de trabalho atribuída.  

### 💉 **Vacinas**  
- Associadas a **uma ou mais espécies**.  
- Se aplicadas a uma espécie errada, podem produzir **efeitos adversos na saúde do animal**.  

---

## 🛠 Funcionalidades Principais  

- 📋 **Gestão de Animais**:  
  - Visualizar, registar, transferir entre habitats e calcular satisfação.  

- 🏡 **Gestão de Habitats**:  
  - Criar habitats, alterar área, gerir árvores e definir influência sobre espécies.  

- 👨‍⚕️ **Gestão de Funcionários**:  
  - Adicionar funcionários, atribuir responsabilidades e calcular satisfação.  

- 💊 **Gestão de Vacinas**:  
  - Registar novas vacinas, vacinar animais e consultar histórico de vacinações.  

- 🔍 **Consultas e Relatórios**:  
  - Consultar animais de um habitat, histórico de vacinas, atos médicos e vacinas administradas de forma incorreta.  

- 📂 **Gestão do Estado da Aplicação**:  
  - Permite guardar e carregar o estado via **serialização Java**.  

---

## 🏗️ Estrutura do Código  

O código é modular e organizado em diferentes pacotes:  

- `hva.core` → Implementação do núcleo do sistema.  
- `hva.app` → Interação com o utilizador e menus de gestão.  
- `hva.app.main` → Menu principal da aplicação.  
- `hva.app.animal` → Gestão de animais.  
- `hva.app.employee` → Gestão de funcionários.  
- `hva.app.habitat` → Gestão de habitats.  
- `hva.app.vaccine` → Gestão de vacinas.  
- `hva.app.search` → Consultas e relatórios.  
