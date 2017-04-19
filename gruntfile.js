/**
 * Created by rahul on 4/14/2017.
 */

//Grunt is just JavaScript running in node, after all...
module.exports = function(grunt) {

    // All upfront config goes in a massive nested object.
    grunt.initConfig({
        // You can set arbitrary key-value pairs.
        distFolder: 'dist',
        // You can also set the value of a key as parsed JSON.
        // Allows us to reference properties we declared in package.json.
        pkg: grunt.file.readJSON('package.json'),
        // Grunt tasks are associated with specific properties.
        // these names generally match their npm package name.
        concat: {
            // Specify some options, usually specific to each plugin.
            options: {
                // Specifies string to be inserted between concatenated files.
                separator: ';'
            },
            // 'dist' is what is called a "target."
            // It's a way of specifying different sub-tasks or modes.
            dist: {
                // The files to concatenate:
                // Notice the wildcard, which is automatically expanded.
                src: ['web/js/localchai/*.js',
                    'web/js/common/*.js',
                    'web/js/localchai/**/*.js',
                    'web/js/localchai/*/*.js'
                ],
                // The destination file:
                // Notice the angle-bracketed ERB-like templating,
                // which allows you to reference other properties.
                // This is equivalent to 'dist/main.js'.
                dest: '<%= distFolder %>/main.js'
                // You can reference any grunt config property you want.
                // Ex: '<%= concat.options.separator %>' instead of ';'
            },
            deploy: {
                // options that are specific to the 'deploy' target
                // target-level options override task-level options
                options: {
                    // separator:';;;' would override the parent setting
                },
                src:['deploy/*.js'],
                dest:'deploy.js'
            }
        },
        uglify: {
            build:{
                src:'<%= distFolder %>/main.js',
                dest:'<%= distFolder %>/main.min.js'
            }
        },
        sass:{
            dist: {
                files: [{
                    expand: true,
                    cwd: 'styles',
                    src: ['web/sass/*.scss'],
                    dest: 'web/images',
                    ext: '.css'
                }]
            }
        }
    }); // The end of grunt.initConfig

    // We've set up each task's configuration.
    // Now actually load the tasks.
    // This will do a lookup similar to node's require() function.
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-sass');



    // Register our own custom task alias.
    grunt.registerTask('build', ['concat']);
    grunt.registerTask('default', ['sass']);
};