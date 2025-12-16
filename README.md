# 🃏 Memory Card Game (Android)

Juego clásico de **Memoria / Memory Cards** desarrollado en **Android (Java)**. El objetivo es encontrar todas las parejas de cartas volteando dos cartas en cada turno. El proyecto está pensado como práctica de lógica, manejo de vistas y temporizadores en Android.

> 📱 Proyecto sencillo, ideal para aprender sobre `ImageButton`, `CountDownTimer`, gestión de estados y lógica de juego.

---

## 🚀 Características

* Tablero de cartas con imágenes aleatorias
* Selección de parejas de forma dinámica
* Animación de giro al pulsar una carta
* Comparación automática de cartas
* Ocultación de parejas acertadas

---

## 🛠️ Tecnologías usadas

* **Lenguaje:** Java
* **IDE:** Android Studio
* **SDK:** Android SDK
* **UI:** XML Layouts
* **Componentes:**

  * `ImageButton`
  * `ImageView`
  * `CountDownTimer`
  * `Toast`

---

## 📂 Estructura del proyecto

```
app/
 ├── java/com/example/memoriacardplaygoog/
 │    ├── MainActivity.java
 │    └── Memoria.java
 │
 ├── res/
 │    ├── drawable/        # Imágenes de cartas y reverso
 │    └── layout/
 │         └── activity_main.xml
```

---

## 🧠 Funcionamiento del juego

1. Al iniciar la aplicación, se seleccionan aleatoriamente pares de imágenes.
2. Las cartas se colocan boca abajo.
3. El jugador pulsa una carta para descubrirla.
4. Al pulsar una segunda carta:

   * Si coinciden, ambas desaparecen.
   * Si no coinciden, se vuelven a ocultar tras un breve tiempo.
5. El juego termina cuando todas las parejas han sido encontradas.

---

## 🌀 Animación

Cada carta tiene una pequeña **animación de rotación** al ser pulsada, mejorando la experiencia visual del juego.

---

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
```

2. Abre el proyecto en **Android Studio**
3. Sincroniza Gradle
4. Ejecuta la app en un emulador o dispositivo físico

---

## 📌 Posibles mejoras futuras

* Contador de intentos
* Temporizador de partida
* Dificultad variable (más cartas)
* Pantalla de reinicio
* Sonidos y efectos
* Guardado de puntuaciones

---

## 👨‍💻 Autor

Desarrollado por **[Tu Nombre]**

---

## 📄 Licencia

Este proyecto es de uso educativo y personal. Puedes modificarlo y adaptarlo libremente.

---

⭐ Si te gusta el proyecto, ¡no olvides darle una estrella en GitHub!
