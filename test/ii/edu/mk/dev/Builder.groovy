package ii.edu.mk.dev

import java.text.SimpleDateFormat;
import java.util.jar.Attributes;

class Builder {
	def String[] jars
	def workspace
	def var
	def ant
		
	static void main(args) {
		Builder builder = new Builder(args[0], args[1])
		builder.generateExecutableJar();
	}
	
    def Builder(String workspace, String propFileName) {
		this.workspace = workspace
		ant = new AntBuilder()
		loadProperties(propFileName)
    }

	void generateExecutableJar() {
		recreateFolder(var.'tmp.dir')
		defineClientJars()
		unzipClientUsedJars();
		generateClientJar("${workspace}/${var.'jar.name'}")
		ant.delete (dir:var.'tmp.dir')
	}
	
	void generateWar() {
		recreateFolder(var.'tmp.dir')
		defineClientJars()
		cleanJnlpFolder()
		//TODO (CV): not done yet
		copyJnlpJars()
		ant.delete (dir:var.'tmp.dir')
	}
	
	void defineClientJars(){
		jars =  ["swingx-core-1.6.2.jar",
				"joda-time-1.6.2.jar",
				"miglayout-3.7.4-swing.jar",
				"log4j-1.2.16.jar",
				"antlr-runtime-3.3.jar",
				
				//for drawing graphs
				"jung/collections-generic-4.01.jar",
				"jung/colt-1.2.0.jar",
				"jung/jung-algorithms-2.0.1.jar",
				"jung/jung-graph-impl-2.0.1.jar",
				"jung/jung-api-2.0.1.jar",
				"jung/jung-visualization-2.0.1.jar"
				] as String[];
	}
	
	void cleanJnlpFolder() {
		ant.delete(includeEmptyDirs:true) {
			fileset(
					dir:workspace + var.'jnlp.dir',
					includes:"**/*.*"
			)
		} 
	}

    // compile client classes and generate the client jar
    void generateClientJar(String destDir) {
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy HH:mm");
        
        ant.javac(
            destdir:var.'tmp.dir',
            source:"1.6",
            target:"1.6",
            debug:"false",
            deprecation:"false",
            optimize:"false",
            failonerror:"true",
            nowarn:"true",
			includeantruntime:"false"
		) {
			//compilerarg(value:"-Xlint")
            src(path:workspace + var.'src.dir')
			
			classpath() {
				fileset(
						dir:workspace,
						excludes:"${var.'lib.src.dir'}/*.*",
						includes:"**/*.jar"
				)
			}
        }
        
        ant.jar(destfile:destDir) {
            fileset(
                    dir:var.'tmp.dir',
                    includes:"**/*.class"
            )
			fileset(
				dir:var.'tmp.dir',
				includes:"org/joda/time/tz/data/**/*"
			)
            fileset(
                    dir:workspace + var.'src.dir',
                    includes:"ii/resources/"
            )
			fileset(
				dir:workspace + var.'src.dir',
				includes:"log4j.properties"
		)
            manifest() {
                attribute(
                        name:Attributes.Name.IMPLEMENTATION_TITLE,
                        value:var.'manifest.title'
                )
                
                attribute(
                        name:Attributes.Name.IMPLEMENTATION_VENDOR,
                        value:var.'manifest.vendor'
                )
                
                attribute(
                        name:Attributes.Name.IMPLEMENTATION_VERSION,
                        value:var.'manifest.version' + "_" + dateFormat.format(currentDate)
                )
                
                attribute(
                        name:Attributes.Name.SPECIFICATION_TITLE,
                        value:var.'manifest.title'
                )
                
                attribute(
                        name:Attributes.Name.SPECIFICATION_VENDOR,
                        value:var.'manifest.vendor'
                )
                
                
                attribute(
                        name:Attributes.Name.SPECIFICATION_VERSION,
                        value:var.'manifest.version'
                )
				
				attribute(
					name:Attributes.Name.MAIN_CLASS,
					value:var.'main.class'
			)

            }
        }
    }    
    
    // copy all required client jar to temporary work folder
    void copyJnlpJars() {
        ant.copy(
        	todir:workspace + var.'jnlp.dir',
        	flatten:true
        ) {
            fileset(
					//should not include all of them
                    dir:workspace + var.'lib.dir',,
                    includes:"**/*.jar"
            )
        }
    }  
	
	void unzipClientUsedJars(){
		jars.each {jar -> 
			ant.unzip(
				src:workspace + var.'lib.dir' + "/" + jar,
				dest:var.'tmp.dir',
				overwrite:true
			);
			ant.delete(
				file:var.'tmp.dir' + "/META-INF/MANIFEST.MF",
			)
		};
	}  
	
	void displayProperties() {
		var.each { item -> println "${item}" }	
	}
	
	void loadProperties(String propFileName) {
		ant.property ( file:"${workspace}/src/" + propFileName )
		var = ant.project.properties
	}
	
	// delete and recreate a folder
	void recreateFolder(String pathToFolder) {
		ant.delete (dir:pathToFolder, includeEmptyDirs:true)
		ant.mkdir(dir:pathToFolder)
	}

}