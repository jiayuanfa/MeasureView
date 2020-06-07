package com.example.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class Fage implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create('fage', FageExtension)
        project.afterEvaluate {
            println("hello ${extension.user}!!")
        }
    }
}
