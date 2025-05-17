
# Git Version Control Commands with Practical Examples

This document explains frequently used Git commands and demonstrates their application in typical version control workflows, including cloning, branching, committing, merging, and resolving conflicts. A demo project (`DemoProject/HelloWorld.java`) is used to illustrate these commands in a practical context, simulating a simple software development scenario.

## Introduction
Git is a distributed version control system that tracks changes to files, enabling collaboration, version management, and rollback. It’s widely used in software development to manage codebases efficiently. The following commands are essential for common workflows, demonstrated with a sample Java project.

## Demo Project Setup
To provide practical examples, a simple Java file (`HelloWorld.java`) is created in `Question2/DemoProject/`. The file’s evolution (e.g., adding features, fixing conflicts) will be tracked using Git commands.

**Initial File (`HelloWorld.java`)**:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Git!");
    }
}
```

## Common Git Commands and Examples

### 1. `git init` - Initialize a Git Repository
- **Purpose**: Creates a new Git repository in the current directory, setting up the `.git` folder for version control.
- **Example**:
  ```bash
  cd Question2/DemoProject
  git init
  ```
  - Initializes a Git repository in `DemoProject/`, enabling version tracking for `HelloWorld.java`.

### 2. `git clone` - Clone a Remote Repository
- **Purpose**: Copies a remote repository to the local machine, including all files and history.
- **Example**:
  Assuming the project is hosted on GitHub:
  ```bash
  git clone https://github.com/username/SoftwareEngineeringAssignments.git
  cd SoftwareEngineeringAssignments
  ```
  - Clones the entire repository, including `Question2/DemoProject/`, to the local machine.

### 3. `git add` - Stage Changes
- **Purpose**: Adds files or changes to the staging area for the next commit.
- **Example**:
  After creating `HelloWorld.java`:
  ```bash
  git add Question2/DemoProject/HelloWorld.java
  ```
  - Stages `HelloWorld.java` for committing.

### 4. `git commit` - Save Changes to the Repository
- **Purpose**: Records staged changes with a descriptive message, creating a snapshot in the repository.
- **Example**:
  ```bash
  git commit -m "Add initial HelloWorld.java implementation"
  ```
  - Commits `HelloWorld.java` to the local repository with a message describing the change.

### 5. `git status` - Check Repository Status
- **Purpose**: Displays the state of the working directory and staging area (e.g., modified or staged files).
- **Example**:
  After modifying `HelloWorld.java`:
  ```bash
  git status
  ```
  - Output:
    ```
    On branch main
    Changes not staged for commit:
      modified:   Question2/DemoProject/HelloWorld.java
    ```
  - Shows `HelloWorld.java` has uncommitted changes.

### 6. `git branch` - Manage Branches
- **Purpose**: Lists, creates, or deletes branches for isolated development.
- **Example**:
  Create a new branch for a feature:
  ```bash
  git branch feature/add-greeting
  git checkout feature/add-greeting
  ```
  - Creates and switches to a branch named `feature/add-greeting`.

### 7. `git checkout` - Switch Branches or Restore Files
- **Purpose**: Switches branches or restores files to a previous state.
- **Example**:
  Switch back to the main branch:
  ```bash
  git checkout main
  ```
  - Returns to the `main` branch.

### 8. `git merge` - Combine Branches
- **Purpose**: Merges changes from one branch into another.
- **Example**:
  On `feature/add-greeting`, modify `HelloWorld.java`:
  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello, Git! Welcome to my project.");
      }
  }
  ```
  Commit the change:
  ```bash
  git add Question2/DemoProject/HelloWorld.java
  git commit -m "Update greeting message in HelloWorld.java"
  ```
  Merge into `main`:
  ```bash
  git checkout main
  git merge feature/add-greeting
  ```
  - Integrates the updated greeting into `main`.

### 9. `git pull` - Fetch and Merge Remote Changes
- **Purpose**: Downloads changes from the remote repository and merges them into the current branch.
- **Example**:
  ```bash
  git pull origin main
  ```
  - Updates the local `main` branch with remote changes (e.g., from a teammate’s push).

### 10. `git push` - Upload Local Changes to Remote
- **Purpose**: Pushes local commits to the remote repository.
- **Example**:
  After committing changes:
  ```bash
  git push origin main
  ```
  - Uploads commits to the remote `main` branch.

### 11. `git log` - View Commit History
- **Purpose**: Displays the commit history with details like commit ID, author, and message.
- **Example**:
  ```bash
  git log --oneline
  ```
  - Output:
    ```
    abc1234 (HEAD -> main) Update greeting message in HelloWorld.java
    def5678 Add initial HelloWorld.java implementation
    ```
  - Shows a concise commit history.

### 12. Resolving Merge Conflicts
- **Purpose**: Handles conflicts when merging branches with overlapping changes.
- **Example**:
  - On `main`, modify `HelloWorld.java`:
    ```java
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello from main branch!");
        }
    }
    ```
    Commit:
    ```bash
    git add Question2/DemoProject/HelloWorld.java
    git commit -m "Update greeting on main branch"
    ```
  - On `feature/add-greeting`, modify the same line:
    ```java
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello from feature branch!");
        }
    }
    ```
    Commit:
    ```bash
    git add Question2/DemoProject/HelloWorld.java
    git commit -m "Update greeting on feature branch"
    ```
  - Merge and encounter a conflict:
    ```bash
    git checkout main
    git merge feature/add-greeting
    ```
    Git reports a conflict in `HelloWorld.java`:
    ```java
    public class HelloWorld {
        public static void main(String[] args) {
    <<<<<<< HEAD
            System.out.println("Hello from main branch!");
    =======
            System.out.println("Hello from feature branch!");
    >>>>>>> feature/add-greeting
        }
    }
    ```
  - Resolve by editing `HelloWorld.java`:
    ```java
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello from both main and feature branches!");
        }
    }
    ```
  - Complete the merge:
    ```bash
    git add Question2/DemoProject/HelloWorld.java
    git commit -m "Resolve merge conflict in HelloWorld.java"
    git push origin main
    ```

## Practical Workflow Example
The following workflow demonstrates a typical Git usage scenario for a team project:
1. **Clone the repository**:
   ```bash
   git clone https://github.com/username/SoftwareEngineeringAssignments.git
   cd SoftwareEngineeringAssignments
   ```
2. **Create a branch**:
   ```bash
   git checkout -b feature/add-greeting
   ```
3. **Modify and commit**:
   - Edit `Question2/DemoProject/HelloWorld.java` to add a new greeting.
   - Stage and commit:
     ```bash
     git add Question2/DemoProject/HelloWorld.java
     git commit -m "Add new greeting to HelloWorld.java"
     ```
4. **Push the branch**:
   ```bash
   git push origin feature/add-greeting
   ```
5. **Create a pull request** (on GitHub) to merge into `main`.
6. **Resolve conflicts** (if any) as shown above.
7. **Pull updates**:
   ```bash
   git checkout main
   git pull origin main
   ```

## Conclusion
These Git commands enable efficient version control:
- **Cloning** (`git clone`) starts a project.
- **Branching** (`git branch`, `git checkout`) isolates changes.
- **Committing** (`git add`, `git commit`) saves snapshots.
- **Merging** (`git merge`) integrates changes.
- **Syncing** (`git pull`, `git push`) collaborates with remote repositories.
- **Conflict Resolution** ensures smooth integration of conflicting changes.
The demo project (`Question2/DemoProject/HelloWorld.java`) illustrates these commands in a practical context, simulating a real-world development workflow.



#### DemoProject/HelloWorld.java Content
To support the practical examples, here’s the initial content for the demo project file. This file evolves through the examples (e.g., modified for branching, merging, and conflict resolution).

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Git!");
    }
}
```

---
