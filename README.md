# Monorepo Gradle Project
The task is to build a Java Spring-based Gradle project to demonstrate monorepo approach that consisting of several projects or services (i.e Service A, B, or C). The structure should be able to do the following
1.  **Build monolithic**: 
    - Build all project under the repository must be built simultaneously
2. **Selective build**
    - Build single project or several projects with specific command

## Overview
A *monorepo* (monolithic repository) is a software development strategy where the code for multiple projects, services, or components is stored in a single version-controlled repository. This approach is commonly used by large organizations like Google, Facebook, and Twitter to manage their codebases efficiently.

This mini project is just to showcase how monorepo approach being implemented, so the services here are only showing a simple "Hello world" message on a browser

### Structure
Here’s the structure used for this mini project:
```
aitminiproject/
├── projects/
│   ├── svcA/               // Service A
│   │   └── build.gradle    // Service A build file (same applies with B and C)
│   │   └── settings.gradle // Service A build setting file
│   ├── svcB/               // Service B
│   └── svcC/               // Service C
├── shared/
│   ├── utils/              // Shared utilities
│   └── models/             // Shared data models
├── README.md               // Repository documentation
├── build.gradle            // Root build file
└── settings.gradle         // Root build setting file
```
## Pre-requisites
### Gradle
This project uses the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html#gradle_wrapper_reference) so you don't need to install Gradle, but you need to make sure that your system satisfies [Gradle prerequisites](https://docs.gradle.org/current/userguide/installation.html#sec:prerequisites) that is Java Development Kit (JDK) version 8 or higher to run.

To check, run `java -version`

```
❯ java -version
openjdk version "21.0.6" 2025-01-21 LTS
OpenJDK Runtime Environment Temurin-21.0.6+7 (build 21.0.6+7-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.6+7 (build 21.0.6+7-LTS, mixed mode, sharing)
```

## Usage

### Building project
To build all project at once, run the following command

```
./gradlew build
```
and for Windows machine, run the following command
```
gradlew.bat build
```

To build specific project, for example service A and C, run the following command 
```
gradlew.bat build :svcA:build :svcC:build
```
### Run the project
To run a specific project, let's say service A, run the following command
```
gradlew.bat :svcA:bootRun
```
These services uses port 8080, so you can open [localhost:8080](http://localhost:8080) on your browser and you should see a message from the service.

To run service B project:
```
gradlew.bat :svcB:bootRun
```

and run service C:
```
gradlew.bat :svcC:bootRun
```
## About Monorepo Approach
### **Key Characteristics of a Monorepo**
1. **Single Repository**: All projects, services, libraries, and tools are stored in one repository.
2. **Shared Codebase**: Common code (e.g., libraries, utilities) can be shared across projects or services.
3. **Unified Versioning**: All components are versioned together, making it easier to manage dependencies.
4. **Atomic Changes**: Changes across multiple projects or services can be made in a single commit, ensuring consistency.
5. **Centralized CI/CD**: A single CI/CD pipeline can be used to build, test, and deploy all components.

### **Advantages of a Monorepo**
1. **Code Reusability**: Shared libraries and utilities can be easily reused across projects.
2. **Simplified Dependency Management**: Dependencies between projects are easier to manage since all code is in one place.
3. **Cross-Project Refactoring**: Refactoring code that spans multiple projects is simpler and less error-prone.
4. **Visibility and Collaboration**: Developers have full visibility into the entire codebase, fostering collaboration.
5. **Atomic Commits**: Changes that affect multiple projects can be committed together, ensuring consistency.
6. **Unified Tooling**: A single set of tools (e.g., linters, formatters, CI/CD pipelines) can be used for the entire codebase.


### **Disadvantages of a Monorepo (and its Solutions)**
1. **Scalability Challenges**: As the repository grows, it can become difficult to manage and slow to clone or check out.

    Solution:
    - Shallow cloning : use git's shallow clone (`--depth`) to fetch only the latest commits, reducing the amount of data downloaded
        ```
        git clone --depth 1 <repository-url>
        ```
    - Sparse checkout: check out only necessary directories / projects
        ```
        git sparse-checkout init --cone
        git sparse-checkout set serviceA serviceB
        ```
        Although it's still experimental, this feature allow user to restrict their working directory to only the files they care about. In monorepo pattern, you can ensure the developer workflow is as fast as possible while maintaining all the benefits of a monorepo


2. **Build Complexity**: Building and testing the entire repository can become time-consuming.

    Solution:
    - **Incremental Builds**: Use build tools like Bazel, Gradle, or Nx that support incremental builds, only rebuilding what has changed.
    - **Parallel Builds**: Configure your build system to run tasks in parallel (e.g., Gradle’s --parallel flag).
    - **Caching**: Use build caching to avoid rebuilding unchanged components. For example, Gradle’s build cache or Bazel’s remote cache.
    - **Modularization**: Structure the monorepo into independent modules or services to minimize unnecessary builds.
3. **Access Control**: Fine-grained access control can be challenging in a monorepo.
    
    Solution:
    - **Permissions Management**: Use Git hosting platforms (e.g., GitHub, GitLab) that support fine-grained permissions for teams and directories.
4. **Coupling Risk**: Poorly managed monorepos can lead to tight coupling between unrelated projects.

    Solution:
    - **Clear Boundaries**: Define clear boundaries between services or modules to prevent unintended dependencies.

    - **Dependency Management**: Use tools like Gradle or Bazel to enforce strict dependency rules and avoid circular dependencies.

    - **Modular Architecture**: Adopt a modular architecture (e.g., microservices, libraries) to isolate functionality and reduce coupling.
    
    - **Documentation**: Maintain clear documentation on the structure and dependencies of the monorepo



### **When to Use a Monorepo**
- **Multiple Related Projects**: When you have multiple projects or services that share code or dependencies.
- **Frequent Cross-Project Changes**: When changes often span multiple projects.
- **Centralized CI/CD**: When you want a single pipeline for building, testing, and deploying all projects.
- **Small to Medium Teams**: When the team size is manageable, and collaboration is a priority.


### **Example Use Cases**
1. **Microservices Architecture**: A monorepo can store all microservices, making it easier to manage shared libraries and dependencies.
2. **Full-Stack Applications**: A monorepo can include both frontend and backend code, ensuring consistency across the stack.
3. **Shared Libraries**: A monorepo can store reusable libraries and utilities for multiple projects.
