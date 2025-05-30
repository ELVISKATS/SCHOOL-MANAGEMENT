[1mdiff --cc target/classes/META-INF/maven/com.nursing/management/pom.properties[m
[1mindex ff9da1b,78b5d2e..0000000[m
[1m--- a/target/classes/META-INF/maven/com.nursing/management/pom.properties[m
[1m+++ b/target/classes/META-INF/maven/com.nursing/management/pom.properties[m
[36m@@@ -1,7 -1,11 +1,7 @@@[m
  #Generated by Maven Integration for Eclipse[m
[31m- #Tue May 13 11:27:03 EAT 2025[m
[31m -//<<<<<<< SchoolManagement[m
[31m -//#Thu May 15 19:44:49 EAT 2025[m
[31m -//=======[m
[31m -//#Wed May 07 15:21:46 EAT 2025[m
[31m -//>>>>>>> main[m
[32m++#Mon May 19 17:02:03 EAT 2025[m
  artifactId=management[m
  groupId=com.nursing[m
[31m -m2e.projectLocation=D\:\\Git_Repositories\\SchoolManagement[m
[32m +m2e.projectLocation=E\:\\JAVA WORKSPACE\\management[m
  m2e.projectName=management[m
  version=0.0.1-SNAPSHOT[m
[1mdiff --cc target/classes/fxml/dashboard.fxml[m
[1mindex 49d7aa2,f6365fa..0000000[m
[1m--- a/target/classes/fxml/dashboard.fxml[m
[1m+++ b/target/classes/fxml/dashboard.fxml[m
[1mdiff --git a/.classpath b/.classpath[m
[1mindex f7e4a1d..197434e 100644[m
[1m--- a/.classpath[m
[1m+++ b/.classpath[m
[36m@@ -14,15 +14,15 @@[m
 	</classpathentry>[m
 	<classpathentry kind="src" output="target/test-classes" path="src/test/java">[m
 		<attributes>[m
[32m+[m			[32m<attribute name="test" value="true"/>[m
 			<attribute name="optional" value="true"/>[m
 			<attribute name="maven.pomderived" value="true"/>[m
[31m-			<attribute name="test" value="true"/>[m
 		</attributes>[m
 	</classpathentry>[m
 	<classpathentry excluding="**" kind="src" output="target/test-classes" path="src/test/resources">[m
 		<attributes>[m
[31m-			<attribute name="maven.pomderived" value="true"/>[m
 			<attribute name="test" value="true"/>[m
[32m+[m			[32m<attribute name="maven.pomderived" value="true"/>[m
 			<attribute name="optional" value="true"/>[m
 		</attributes>[m
 	</classpathentry>[m
[36m@@ -36,5 +36,6 @@[m
 			<attribute name="maven.pomderived" value="true"/>[m
 		</attributes>[m
 	</classpathentry>[m
[32m+[m	[32m<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/javaFX"/>[m
 	<classpathentry kind="output" path="target/classes"/>[m
 </classpath>[m
[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex dc5f01b..1dfac47 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -46,6 +46,6 @@[m
             </configuration>[m
         </plugin>[m
     </plugins>[m
[31m-</build>S[m
[32m+[m[32m</build>[m
 [m
 </project>[m
[1mdiff --git a/src/main/java/com/nursing/management/Main.java b/src/main/java/com/nursing/management/Main.java[m
[1mindex ce12ea0..d52ead0 100644[m
[1m--- a/src/main/java/com/nursing/management/Main.java[m
[1m+++ b/src/main/java/com/nursing/management/Main.java[m
[36m@@ -9,7 +9,7 @@[m [mimport javafx.stage.Stage;[m
 public class Main extends Application{[m
 	@Override[m
 	public void start(Stage primaryStage) throws Exception{[m
[31m-		Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));[m
[32m+[m		[32mParent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));[m
 		primaryStage.setTitle("Nursing Management System");[m
 		primaryStage.setScene(new Scene(root,800,600));[m
 		primaryStage.show();[m
[1mdiff --git a/src/main/java/com/nursing/management/controllers/DashboardController.java b/src/main/java/com/nursing/management/controllers/DashboardController.java[m
[1mindex 13e3fcf..e3e9c03 100644[m
[1m--- a/src/main/java/com/nursing/management/controllers/DashboardController.java[m
[1m+++ b/src/main/java/com/nursing/management/controllers/DashboardController.java[m
[36m@@ -1,6 +1,7 @@[m
 package com.nursing.management.controllers;[m
 import java.awt.Button;//Fix: Replace java.awt.Button with javafx.scene.control.Button.[m
 import java.io.IOException;[m
[32m+[m
 import javafx.fxml.FXML;[m
 import javafx.fxml.FXMLLoader;[m
 import javafx.scene.Scene;[m
[36m@@ -17,7 +18,7 @@[m [mpublic class DashboardController{[m
 	@FXML private Button btnOtherDetails;[m
 	@FXML private Button btnLogout;[m
 	@FXML[m
[31m-	[m
[32m+[m
 	private void Initialise() {[m
 		setupButtonHoverEffects(btnPersonalInfo);[m
 		setupButtonHoverEffects(btnNextOfKin);[m
[36m@@ -25,19 +26,19 @@[m [mpublic class DashboardController{[m
 		setupButtonHoverEffects(btnEmergencyContacts);[m
 		setupButtonHoverEffects(btnMedicalInfo);[m
 		setupButtonHoverEffects(btnOtherDetails);[m
[31m-		[m
[32m+[m
 	}[m
 	private void setupButtonHoverEffects(Button button) {[m
[31m-		button.setOnMouseEntered(e-> button.setStyle("fx-background-Color:#3a7bd5; -fx-text-fill:white;"));[m
[31m-		button.setOnMouseExited(e-> button.setStyle("fx-background-color:#002dff; -fx-text-fill:black;"));[m
[32m+[m		[32m//button.setOnMouseEntered(e-> button.setStyle("fx-background-Color:#3a7bd5; -fx-text-fill:white;"));[m
[32m+[m		[32m//button.setOnMouseExited(e-> button.setStyle("fx-background-color:#002dff; -fx-text-fill:black;"));[m
 	}[m
[31m-	[m
[32m+[m
 	@FXML[m
 	private void handlePersonalInfo() {[m
 		loadStudentList("personal Information");[m
 	}[m
 	@FXML[m
[31m-	[m
[32m+[m
 	private void handleNextOfKin() {[m
 		loadStudentList("Next Of Kin");[m
 	}[m
[36m@@ -48,7 +49,7 @@[m [mpublic class DashboardController{[m
 	@FXML[m
 	private void handleEmergencyContacts() {[m
 		loadStudentList("Emergency Contacts");[m
[31m-		[m
[32m+[m
 	}[m
 	@FXML[m
 	private void HandleMedicalInfo() {[m
[36m@@ -58,31 +59,31 @@[m [mpublic class DashboardController{[m
 	private void handleOtherDetails() {[m
 		loadStudentList("Other Details");[m
 	}[m
[31m-	[m
[32m+[m
 	private void loadStudentList(String category) {[m
[31m-		[m
[32m+[m
 	try {[m
 		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/student_list.fxml"));[m
 		Stage stage =(Stage)dashboardGrid.getScene().getWindow();[m
 		stage.setScene(new Scene(loader.load()));[m
[31m-		[m
[32m+[m
 		StudentListController controller = loader.getController();[m
 		controller.setCategory(category);[m
 	}catch(IOException e) {[m
 		e.printStackTrace();[m
 	}[m
[31m-	[m
[31m-	}[m
 [m
[31m-@FXML[m
[31m-private void handleLogout() {[m
[31m-	try {[m
[31m-		FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/login.fxml"));[m
[31m-		Stage stage =(Stage)btnLogout.getScene().getWindow();[m
[31m-		stage.setScene(new Scene(loader.load()));[m
[31m-	}catch(IOException e) {[m
[31m-		e.printStackTrace();[m
 	}[m
[31m-}[m
[32m+[m
[32m+[m[32m//@FXML[m
[32m+[m[32m//private void handleLogout() {[m
[32m+[m[32m//	try {[m
[32m+[m[32m//		FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/login.fxml"));[m
[32m+[m[32m//		Stage stage =(Stage)btnLogout.getScene().getWindow();[m
[32m+[m[32m//		stage.setScene(new Scene(loader.load()));[m
[32m+[m[32m//	}catch(IOException e) {[m
[32m+[m[32m//		e.printStackTrace();[m
[32m+[m[32m//	}[m
[32m+[m[32m//}[m
 [m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/nursing/management/controllers/StudentListController.java b/src/main/java/com/nursing/management/controllers/StudentListController.java[m
[1mindex f3bf9a2..ce1c640 100644[m
[1m--- a/src/main/java/com/nursing/management/controllers/StudentListController.java[m
[1m+++ b/src/main/java/com/nursing/management/controllers/StudentListController.java[m
[36m@@ -1,16 +1,25 @@[m
[32m+[m
[32m+[m
 package com.nursing.management.controllers;[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m
[32m+[m[32mimport com.nursing.management.dao.StudentDAO;[m
[32m+[m[32mimport com.nursing.management.models.Student;[m
 [m
[31m-import javafx.fxml.FXML;[m
[31m-import javafx.scene.Scene;[m
[31m-import javafx.scene.control.*;[m
 import javafx.collections.FXCollections;[m
 import javafx.collections.ObservableList;[m
[32m+[m[32mimport javafx.fxml.FXML;[m
[32m+[m[32mimport javafx.fxml.FXMLLoader;[m
[32m+[m[32mimport javafx.scene.Scene;[m
[32m+[m[32mimport javafx.scene.control.Alert;[m
[32m+[m[32mimport javafx.scene.control.Button;[m
[32m+[m[32mimport javafx.scene.control.ButtonType;[m
[32m+[m[32mimport javafx.scene.control.Label;[m
[32m+[m[32mimport javafx.scene.control.TableColumn;[m
[32m+[m[32mimport javafx.scene.control.TableColumnBase;[m
[32m+[m[32mimport javafx.scene.control.TableView;[m
 import javafx.scene.control.cell.PropertyValueFactory;[m
[31m-import com.nursing.management.models.Student;[m
[31m-import com.nursing.management.dao.StudentDAO;[m
 import javafx.stage.Stage;[m
[31m-import javafx.fxml.FXMLLoader;[m
[31m-import java.io.IOException;[m
 [m
 [m
 public class StudentListController {[m
[36m@@ -30,7 +39,7 @@[m [mpublic class StudentListController {[m
     private String currentCategory;[m
 [m
 [m
[31m-    /*The initialisation method that loads up the table with data from the backend.[m
[32m+[m[32m    /*The initialization method that loads up the table with data from the backend.[m
     This method is called automatically when the FXML loads.[m
     This also contains the method that search functionality with the options of[m
     case sensitivity and the id search[m
[1mdiff --git a/src/main/resources/fxml/login.fxml b/src/main/resources/fxml/login.fxml[m
[1mindex 649f017..bfdf5d6 100644[m
[1m--- a/src/main/resources/fxml/login.fxml[m
[1m+++ b/src/main/resources/fxml/login.fxml[m
[36m@@ -1,6 +1,6 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 [m
[31m-<?import com.gluonhq.charm.glisten.control.Avatar?>[m
[32m+[m
 <?import javafx.scene.Cursor?>[m
 <?import javafx.scene.control.Button?>[m
 <?import javafx.scene.control.CheckBox?>[m
[36m@@ -44,6 +44,5 @@[m
             <Image url="@../images/userCircle.png" />[m
          </image>[m
       </ImageView>[m
[31m-      <Avatar layoutX="278.0" layoutY="41.0" />[m
    </children>[m
 </AnchorPane>[m
[1mdiff --git a/target/classes/.gitignore b/target/classes/.gitignore[m
[1mdeleted file mode 100644[m
[1mindex 0fb5df8..0000000[m
[1m--- a/target/classes/.gitignore[m
[1m+++ /dev/null[m
[36m@@ -1,2 +0,0 @@[m
[31m-/com/[m
[31m-/META-INF/[m
[1mdiff --git a/target/classes/META-INF/MANIFEST.MF b/target/classes/META-INF/MANIFEST.MF[m
[1mindex 9bdf3b1..0e15486 100644[m
[1m--- a/target/classes/META-INF/MANIFEST.MF[m
[1m+++ b/target/classes/META-INF/MANIFEST.MF[m
[36m@@ -1,4 +1,4 @@[m
 Manifest-Version: 1.0[m
[31m-Build-Jdk-Spec: 21[m
[32m+[m[32mBuild-Jdk-Spec: 23[m
 Created-By: Maven Integration for Eclipse[m
 [m
[1mdiff --git a/target/classes/META-INF/maven/com.nursing/management/pom.xml b/target/classes/META-INF/maven/com.nursing/management/pom.xml[m
[1mindex dc5f01b..1dfac47 100644[m
[1m--- a/target/classes/META-INF/maven/com.nursing/management/pom.xml[m
[1m+++ b/target/classes/META-INF/maven/com.nursing/management/pom.xml[m
[36m@@ -46,6 +46,6 @@[m
             </configuration>[m
         </plugin>[m
     </plugins>[m
[31m-</build>S[m
[32m+[m[32m</build>[m
 [m
 </project>[m
[1mdiff --git a/target/classes/com/nursing/management/Main.class b/target/classes/com/nursing/management/Main.class[m
[1mindex 4a91e95..ffb0a35 100644[m
Binary files a/target/classes/com/nursing/management/Main.class and b/target/classes/com/nursing/management/Main.class differ
[1mdiff --git a/target/classes/com/nursing/management/controllers/DashboardController.class b/target/classes/com/nursing/management/controllers/DashboardController.class[m
[1mindex 99f4d15..fce3170 100644[m
Binary files a/target/classes/com/nursing/management/controllers/DashboardController.class and b/target/classes/com/nursing/management/controllers/DashboardController.class differ
[1mdiff --git a/target/classes/com/nursing/management/controllers/StudentListController.class b/target/classes/com/nursing/management/controllers/StudentListController.class[m
[1mindex 2e65a8e..7ab4449 100644[m
Binary files a/target/classes/com/nursing/management/controllers/StudentListController.class and b/target/classes/com/nursing/management/controllers/StudentListController.class differ
[1mdiff --git a/target/classes/fxml/login.fxml b/target/classes/fxml/login.fxml[m
[1mindex 649f017..bfdf5d6 100644[m
[1m--- a/target/classes/fxml/login.fxml[m
[1m+++ b/target/classes/fxml/login.fxml[m
[36m@@ -1,6 +1,6 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 [m
[31m-<?import com.gluonhq.charm.glisten.control.Avatar?>[m
[32m+[m
 <?import javafx.scene.Cursor?>[m
 <?import javafx.scene.control.Button?>[m
 <?import javafx.scene.control.CheckBox?>[m
[36m@@ -44,6 +44,5 @@[m
             <Image url="@../images/userCircle.png" />[m
          </image>[m
       </ImageView>[m
[31m-      <Avatar layoutX="278.0" layoutY="41.0" />[m
    </children>[m
 </AnchorPane>[m
