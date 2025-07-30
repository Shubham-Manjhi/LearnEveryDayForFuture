# 📘 LeetCode 68: Text Justification

---

## ✅ 0. Question

Given an array of words and a maximum width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach: that is, pack as many words as you can in each line. Pad extra spaces `' '` so that each line has exactly `maxWidth` characters.

### Example:
```text
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16

Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

---

## ✅ 1. Definition and Purpose

- Text justification aligns text to both left and right margins.
- Used in UI formatting, word processors, and PDF rendering engines.
- Greedy line breaking and space balancing are core challenges.

---

## ✅ 2. Syntax and Structure

```java
public List<String> fullJustify(String[] words, int maxWidth);
```

- Input: array of words, and a maximum width.
- Output: list of justified lines.

---

## ✅ 3. Practical Examples

### 🔹 Java Code (Greedy Line Build + Justification)
```java
public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int index = 0;

    while (index < words.length) {
        int totalChars = words[index].length();
        int last = index + 1;

        // Step 1: Determine how many words fit in current line
        while (last < words.length) {
            if (totalChars + 1 + words[last].length() > maxWidth) break;
            totalChars += 1 + words[last].length();
            last++;
        }

        StringBuilder builder = new StringBuilder();
        int wordsCount = last - index;

        // Step 2: If it's the last line or single word
        if (last == words.length || wordsCount == 1) {
            for (int i = index; i < last; i++) {
                builder.append(words[i]);
                if (i < last - 1) builder.append(" ");
            }
            int remaining = maxWidth - builder.length();
            while (remaining-- > 0) builder.append(" ");
        } else {
            int spaces = maxWidth - totalChars + (wordsCount - 1);
            int spaceBetweenWords = spaces / (wordsCount - 1);
            int extraSpaces = spaces % (wordsCount - 1);

            for (int i = index; i < last; i++) {
                builder.append(words[i]);
                if (i < last - 1) {
                    for (int s = 0; s < spaceBetweenWords + (i - index < extraSpaces ? 1 : 0); s++) {
                        builder.append(" ");
                    }
                }
            }
        }

        result.add(builder.toString());
        index = last;
    }

    return result;
}
```

### Example:
```text
Line 1: "This    is    an" (3 spaces evenly between words)
Line 2: "example  of text"
Line 3: "justification.  " (last line, left justified)
```

---

## ✅ 4. Internal Working

- Greedily group as many words as possible for each line.
- Balance spaces evenly, with leftover spaces going to the left-most gaps.
- Final line or single word lines are left-justified.

---

## ✅ 5. Best Practices

- Use StringBuilder for efficient string concatenation.
- Handle edge cases like single-word lines and final line separately.
- Keep track of total character length vs. total spaces to insert.

---

## ✅ 6. Related Concepts

- Greedy Algorithms
- Word Wrapping
- Dynamic Space Distribution

---

## ✅ 7. Interview & Real-world Use

- Often asked in interviews to assess formatting logic and edge case handling.
- Used in terminal text formatting, GUI display engines.

---

## ✅ 8. Common Errors & Debugging

- Misplacing extra spaces
- Incorrectly left-justifying middle lines
- Off-by-one bugs in space calculations

---

## ✅ 9. Java Version Updates

- StringBuilder available since Java 5
- Java 8+ Streams can help if implemented differently

---

## ✅ 10. Practice and Application

- LeetCode 68: Text Justification
- Word Wrapping with minimum line cost
- Real-time UI formatting in mobile apps

---

📚 Mastering text justification improves your handling of strings, formatting, and edge-case resilience in interviews and systems!

