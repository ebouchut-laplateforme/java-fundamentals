# Java Fundamentals Exercices

## Presentation

This project contains hands-on exercises based on the great Udemy video course
about [Java Fundamentals](https://www.udemy.com/course/java-fundamentals-beginners/) by Jean Claude Bazin's.

## Documentation

### Access Modifiers and Encapsulation

An **access modifier** defines the visibility of the class, field/attribute, or method it is applied to:

- `private`: accessible only in the class in which it is defined.
- `default`: also known as *package-private*, accessible only in the *package* it is defined in. To use package-private we do not specify the access modifier.
- `protected`: accessible only in:
    - the same *package*
    - the same *class*
    - the *subclasses*
- `public`: accessible *everywhere* to *everyone*

| Access Modifier | Same Class | Class in the same package | Class in another package | Subclass in the same package | Subclass in another package |
| --------------- | ---------- | ------------------------- | ------------------------ | ---------------------------- | --------------------------- |
| `public`        | ✅          | ✅                         | ✅                        | ✅                            | ✅                           |
| `private`       | ✅          | ❌                         | ❌                        | ❌                            | ❌                           |
| `protected`     | ✅          | ✅                         | ❌                        | ✅                            | ✅                           |
| package-private | ✅          | ✅                         | ❌                        | ✅                            | ❌                           |

Let's break down these access modifiers with visual class diagrams.

```mermaid
---
title: public Access Modifier
---
classDiagram
    direction TB
    
    namespace SamePackage {
        class Class:::can_access {
            +attribute String
            +method()  void
        }
        class Subclass["Subclass same package"]:::can_access {
        }
    }
    note for Class "attribute and method have **public** access"
    Class <|-- Subclass
    
    namespace OtherPackage {
        class SubclassOtherPackage["Subclass different package"]:::can_access {
        }
        class ClassOtherPackage["Other class different package"]:::can_access {
            
        }
    }
    Class <|-- SubclassOtherPackage
    
    
    classDef can_access fill:#76b192
```

```mermaid
---
title: private Access Modifier
---
classDiagram
    direction TB
    
    namespace SamePackage {
        class Class:::can_access {
            -attribute String
            -method()  void
        }
        class Subclass["Subclass same package"]:::cannot_access {
        }
    }
    note for Class "attribute and method have **private** access"
    Class <|-- Subclass
    
    namespace OtherPackage {
        class SubclassOtherPackage["Subclass different package"]:::cannot_access {
        }
        class ClassOtherPackage["Other class different package"]:::cannot_access {
            
        }
    }
    Class <|-- SubclassOtherPackage
    
    
    classDef can_access    fill:#76B192
    classDef cannot_access fill:#D74345
```

```mermaid
---
title: protected Access Modifier
---
classDiagram
    direction TB
    
    namespace SamePackage {
        class Class:::can_access {
            #attribute String
            #method()  void
        }
        class Subclass["Subclass same package"]:::can_access {
        }
    }
    note for Class "attribute and method have **protected** access"
    Class <|-- Subclass
    
    namespace OtherPackage {
        class SubclassOtherPackage["Subclass different package"]:::can_access {
        }
        class ClassOtherPackage["Other class different package"]:::cannot_access {
            
        }
    }
    Class <|-- SubclassOtherPackage
    
    
    classDef can_access    fill:#76B192
    classDef cannot_access fill:#D74345
```

```mermaid
---
title: package-private Access Modifier
---
classDiagram
    direction TB
    
    namespace SamePackage {
        class Class:::can_access {
            ~attribute String
            ~method()  void
        }
        class Subclass["Subclass same package"]:::can_access {
        }
    }
    note for Class "attribute and method have **package-private** (default) access"
    Class <|-- Subclass
    
    namespace OtherPackage {
        class SubclassOtherPackage["Subclass different package"]:::cannot_access {
        }
        class ClassOtherPackage["Other class different package"]:::cannot_access {
            
        }
    }
    Class <|-- SubclassOtherPackage
    
    
    classDef can_access    fill:#76B192
    classDef cannot_access fill:#D74345
```


