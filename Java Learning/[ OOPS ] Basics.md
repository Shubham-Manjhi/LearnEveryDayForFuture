<div align="center">
  <h1 style="color: #2E86C1; font-size: 32px;">📘 OOPs: What is Object-Oriented Programming?</h1>
</div>



⸻


<h2 style="color: #117A65; text-align: center;">✅ What is OOP?</h2>
<p><strong>Object-Oriented Programming (OOP)</strong> is a programming paradigm based on the concept of "objects", which can contain data and code. Data in the form of fields (also known as attributes), and code in the form of procedures (also known as methods).</p>
<p>In Java, everything revolves around objects and classes. Java is an object-oriented language that helps model real-world entities and design scalable applications.</p>



⸻


<h2 style="color: #117A65; text-align: center;">🎯 Why Use OOP?</h2>
<ul>
  <li>Model real-world behavior and interactions</li>
  <li>Enhance code reusability, readability, and maintainability</li>
  <li>Promote modular and structured programming</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">🧱 Four Pillars of OOP</h2>


<h3 style="color: #5D6D7E;">1. Encapsulation</h3>
<p><strong>Definition:</strong> Wrapping data (variables) and methods into a single unit (class) and restricting access using access modifiers.</p>
<pre><code class="language-java">public class Student {
    private String name; // hidden from outside


public void setName(String name) {
    this.name = name;
}
public String getName() {
    return name;
}

}

<p><em>Analogy: ATM hides its internal logic. Users interact via buttons.</em></p>


<h3 style="color: #5D6D7E;">2. Inheritance</h3>
<p><strong>Definition:</strong> Allows a class (child) to inherit attributes and methods from another class (parent).</p>
<pre><code class="language-java">class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}


class Dog extends Animal {
void bark() {
System.out.println(“Barking…”);
}
}

<p><em>Analogy: A Dog "is-a" Animal and inherits behavior like eating.</em></p>


<h3 style="color: #5D6D7E;">3. Polymorphism</h3>
<p><strong>Definition:</strong> One interface, multiple forms. Java supports:</p>
<ul>
  <li>Method Overloading (Compile-time Polymorphism)</li>
  <li>Method Overriding (Runtime Polymorphism)</li>
</ul>
<pre><code class="language-java">// Overloading
class Math {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}


// Overriding
class Animal {
void sound() { System.out.println(“Some sound”); }
}
class Dog extends Animal {
void sound() { System.out.println(“Bark”); }
}

<p><em>Analogy: A person behaves differently as a teacher, parent, or customer.</em></p>


<h3 style="color: #5D6D7E;">4. Abstraction</h3>
<p><strong>Definition:</strong> Hiding implementation details and exposing only essential features.</p>
<pre><code class="language-java">abstract class Shape {
    abstract void draw();
}


class Circle extends Shape {
void draw() {
System.out.println(“Drawing Circle”);
}
}

<p><em>Analogy: You use a smartphone but don’t know how its circuits work.</em></p>



⸻


<h2 style="color: #117A65; text-align: center;">🧠 Other Key OOP Concepts</h2>
<ul>
  <li><strong>Class:</strong> Blueprint for creating objects</li>
  <li><strong>Object:</strong> Instance of a class</li>
  <li><strong>Constructor:</strong> Initializes new objects</li>
  <li><strong>this:</strong> Refers to current object</li>
  <li><strong>super:</strong> Refers to parent class</li>
</ul>



⸻


<h2 style="color: #117A65; text-align: center;">🧪 Summary Table</h2>
<table border="1" cellpadding="6" style="margin:auto">
  <thead><tr><th>Pillar</th><th>Description</th></tr></thead>
  <tbody>
    <tr><td>Encapsulation</td><td>Hides internal state via private fields</td></tr>
    <tr><td>Inheritance</td><td>Reuses code from parent class</td></tr>
    <tr><td>Polymorphism</td><td>Same interface, multiple behaviors</td></tr>
    <tr><td>Abstraction</td><td>Hides complexity, exposes functionality</td></tr>
  </tbody>
</table>



⸻


<h2 style="color: #117A65; text-align: center;">📚 Interview Tip</h2>
<p>Be ready to explain all 4 pillars with real-world and coding examples. Interviewers may ask you to implement them in code or find OOP violations in a sample class.</p>



⸻
