  /*
     * THE Students data method to add, edit and delete the students data
     * This is the overall method that connects to the graphs of the opening login form.
     * #Keep Coding, No one ever regrets working harder
     * @KATO ELVIS.dev/2637/477/NRD.
     * */
package com.nursing.management.controllers;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.nursing.management.studentsBio;
import com.nursing.management.auth.DatabaseConnector;
import com.nursing.management.dao.alertMessage;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DashboardController implements Initializable{
    @FXML
    private Button StudentsGrade_btn;
    

    @FXML
    private TableView<studentsBio> gradeTable;
    @FXML
    private TableColumn<studentsBio, String> Table_name;

    @FXML
    private TableColumn<studentsBio, String> Table_nsin;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem1_p1;

    @FXML                                                                
    private TableColumn<studentsBio, Integer> Table_year1_sem1_p2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem1_p3;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem1_p4;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem2_p1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem2_p2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem2_p3;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year1_sem2_p4;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem1_p1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem1_p2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem1_p3;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem1_p4;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem2_p1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem2_p2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem2_p3;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year2_sem2_p4;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year3_sem1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year3_sem1_p1;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year3_sem1_p2;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year3_sem1_p3;

    @FXML
    private TableColumn<studentsBio, Integer> Table_year3_sem1_p4;
    
    
    @FXML
    private Button close_btn;

    @FXML
    private TextField gradeForm_NAME;

    @FXML
    private TextField gradeForm_NSIN;

    @FXML
    private Button grade_DelBtn;

    @FXML
    private AnchorPane grade_Form;

    @FXML
    private Button grade_addBtn;

    @FXML
    private Button grade_clearBtn;

    @FXML
    private TextField grade_search;

    @FXML
    private AnchorPane home_Form;

    @FXML
    private Button home_btn;

    @FXML
    private AreaChart<?, ?> home_female_chart;

    @FXML
    private Label home_female_total;

    @FXML
    private AreaChart<?, ?> home_male_chart;

    @FXML
    private Label home_male_total;

    @FXML
    private Label home_total;

    @FXML
    private BarChart<?, ?> home_total_chart;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimise_btn;

    @FXML
    private TextField register_Alevel;

    @FXML
    private DatePicker register_DOB;

    @FXML
    private AnchorPane register_Form;

    @FXML
    private TextField register_LName;

    @FXML
    private TextField register_NIN;

    @FXML
    private TextField register_NSIN;

    @FXML
    private TextField register_Olevel;

    @FXML
    private Button register_add_btn;

    @FXML
    private Button register_btn;

    @FXML
    private Button register_clear_btn;

    @FXML
    private TextField register_contact;

    @FXML
    private TextField register_county;

    @FXML
    private TextField register_current_medication;

    @FXML
    private Button register_delete_btn;

    @FXML
    private TextField register_district;

    @FXML
    private TextField register_doneCourse;

    @FXML
    private TextField register_email;

    @FXML
    private TextArea register_emergencyProcedures;

    @FXML
    private TextField register_emergency_name;

    @FXML
    private TextField register_emrgency_contact1;

    @FXML
    private TextField register_emrgency_contact2;

    @FXML
    private TextField register_fname;

    @FXML
    private AnchorPane register_form;

    @FXML
    private TextField register_gardian1_contact1;

    @FXML
    private TextField register_gardian1_contact2;

    @FXML
    private TextField register_gardian1_county;

    @FXML
    private TextField register_gardian1_district;

    @FXML
    private TextField register_gardian1_email;

    @FXML
    private TextField register_gardian1_nin;

    @FXML
    private TextField register_gardian1_occupation;

    @FXML
    private TextField register_gardian1_parish;

    @FXML
    private TextField register_gardian1_subcounty;

    @FXML
    private TextField register_gardian1_village;

    @FXML
    private TextField register_gardian2_contact1;

    @FXML
    private TextField register_gardian2_contact2;

    @FXML
    private TextField register_gardian2_county;

    @FXML
    private TextField register_gardian2_district;

    @FXML
    private TextField register_gardian2_email;

    @FXML
    private TextField register_gardian2_name;

    @FXML
    private TextField register_gardian2_nin;

    @FXML
    private TextField register_gardian2_occupation;

    @FXML
    private TextField register_gardian2_parish;

    @FXML
    private TextField register_gardian2_subcounty;

    @FXML
    private TextField register_gardian2_village;

    @FXML
    private TextField register_gardianName1;

    @FXML
    private TextField register_medical_conditions;

    @FXML
    private TextField register_middleName;

   

    @FXML
    private TextField register_parish;

    @FXML
    private TextField register_physician_contact;

    @FXML
    private TextField register_relationship;

    @FXML
    private TextField register_religion;

    @FXML
    private TextField register_search;

    @FXML
    private TextArea register_specialNeeds;

    @FXML
    private TextField register_subcounty;

    @FXML
    private TableView<studentsBio> register_tableView;
    
    @FXML
    private TableColumn<studentsBio, Integer> register_Age_col;

    @FXML
    private TableColumn<studentsBio, String> register_religion_col;
    
    @FXML
    private TableColumn<studentsBio, String> register_nsin_col;
    @FXML
    private TableColumn<studentsBio, String> register_gender_col;

    @FXML
    private TableColumn<studentsBio, Integer> register_contact_col;

//    @FXML
//    private TableColumn<studentsBio, String> register_DOB_col;

    @FXML
    private TableColumn<studentsBio, String> register_Fname_col;
    
    @FXML
    private TableColumn<studentsBio, String> register_Lname_col;
    
    @FXML
    private ComboBox<String> register_courseLevel;

    @FXML
    private ComboBox<String> register_courseTaken;

    @FXML
    private ComboBox<String> register_courseYear;

    @FXML
    private ComboBox<String> register_gender;
    
    @FXML
    private ComboBox<String> register_semester;




    @FXML
    private Button register_update_btn;

    @FXML
    private TextField register_year_done;

    @FXML
    private ImageView signOut_btn;

    @FXML
    private Button studentsList_btn;

    @FXML
    private TextField year1_sem1_p1;

    @FXML
    private TextField year1_sem1_p2;

    @FXML
    private TextField year1_sem1_p3;

    @FXML
    private TextField year1_sem1_p4;

    @FXML
    private TextField year1_sem2_p1;

    @FXML
    private TextField year1_sem2_p2;

    @FXML
    private TextField year1_sem2_p3;

    @FXML
    private TextField year1_sem2_p4;

    @FXML
    private TextField year2_sem2_p1;

    @FXML
    private TextField year2_sem2_p2;

    @FXML
    private TextField year2_sem2_p3;

    @FXML
    private TextField year2_sem2_p4;

    @FXML
    private TextField year2_sem_p1;

    @FXML
    private TextField year2_sem_p2;
    
    @FXML
    private TextField register_student_contact1;

    @FXML
    private TextField register_student_contact2;

    @FXML
    private TextField year2_sem_p3;

    @FXML
    private TextField year2_sem_p4;
    
    @FXML
    private AnchorPane details_Form;
    
    @FXML
    private TextField year3_sem2_p4;

    @FXML
    private TextField year3_sem_p1;

    @FXML
    private TextField year3_sem_p2;

    @FXML
    private TextField year3_sem1_p3;
    

    @FXML
    private TableColumn<studentsBio, Integer> details_Age_col;

    @FXML
    private TableColumn<studentsBio, String> details_Fname_col;

    @FXML
    private TableColumn<studentsBio, String> details_Lname_col;

    @FXML
    private TableColumn<studentsBio, Integer> details_contact_col;

    @FXML
    private TableColumn<studentsBio, String> details_gender_col;

    @FXML
    private TableColumn<studentsBio, String> details_nsin_col;

    @FXML
    private TableColumn<studentsBio, String> details_religion_col;

    @FXML
    private TableView<studentsBio> details_tableView;
    
    @FXML
    private TextField detailsSearch;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    alertMessage ALERT = new alertMessage();
    
    // # Prompt Method for Gender
      private String [] genderList = {"Female","Male"};
     private boolean IsUpdatingGender = false;
     public void addGender() {
    	 if(IsUpdatingGender)return;
    	 IsUpdatingGender = true;
    	 try {  //To avoid Infinite Loops...
    		 List<String> genderL = new ArrayList<>();
        	 for(String data: genderList) {
        		 genderL.add(data);
        	 }
        	 ObservableList OBlist = FXCollections.observableArrayList(genderL);
        	 if(register_gender != null && !OBlist.equals(register_gender.getItems())) {
        		 register_gender.setItems(OBlist);
        	 }
        	 
         }finally {
        	 IsUpdatingGender = false;
         }
    	 }
    
     // # Semester Prompt
     private String [] semisterList = {"SEM 1","SEM 2"};
     private boolean IsUpdatingSemester = false;
     public void addSem() {
    	 if(IsUpdatingSemester) return;
    	 IsUpdatingSemester = true;
    	 try {
    		 List<String> SemList = new ArrayList<>();
        	 for(String data: semisterList) {
        		 SemList.add(data);
        	 }
        	 ObservableList ObsvList = FXCollections.observableArrayList(SemList);
        	 if(register_semester != null && !ObsvList.equals(register_semester.getItems())) {
        		 register_semester.setItems(ObsvList);
        	 }
    	 }finally {
    		 IsUpdatingSemester = false;
    	 }
     }
     
  // # Year Prompt
     private String [] yearList = {"Year 1","Year 2","Year 3"};
     private boolean IsUpdatingYear = false;
     public void addYear() {
    	 if(IsUpdatingYear)return;
    	 IsUpdatingYear = true;
    	 try {
    		 List<String> yearL = new ArrayList<>();
        	 for(String data: yearList) {
        		 yearL.add(data);
        	 } 
        	 ObservableList OL = FXCollections.observableArrayList(yearL);
        	 if(register_courseYear != null && !OL.equals(register_courseYear.getItems())) {
        		 register_courseYear.setItems(OL);
        	 }
    	 } finally {
    		 IsUpdatingYear = false;
    	 }
     }
     
     //# Course List
     private String [] courseList = {"Nursing","Midwifrey","Direct Nursing","Direct Midwifrey","Extension In Nursing", "Extension In Midwifrey"};
     private boolean UpdateCourse = false;
     public void addCourse() {
    	 if(UpdateCourse)return;
    	 UpdateCourse = true;
    	 try {
    		 List<String> courseL = new ArrayList<>();
        	 for(String data : courseList) {
        		 courseL.add(data);
        	 } 
        	 ObservableList OBL = FXCollections.observableArrayList(courseL);
        	 if(register_courseTaken != null && !OBL.equals(register_courseTaken.getItems())) {
        		 register_courseTaken.setItems(OBL);
        	 }
    	 }finally {
    		 UpdateCourse = false;
    	 }
     }
   
     //#Course Level
     private String[] courseLevel = {"Certificate","Diploma"};
     private boolean UpdateLevel = false;
     public void addLevel() {
    	 if(UpdateLevel)return;
    	 UpdateLevel = true;
    	 try {
    		 List<String> courseL = new ArrayList();
        	 for(String data : courseLevel) {
        		 courseL.add(data);
        	 }
        	 ObservableList OBL = FXCollections.observableList(courseL);
        	 if(register_courseLevel != null && !OBL.equals(register_courseLevel.getItems())) {
        		 register_courseLevel.setItems(OBL);	 
        	 }
    	 }finally {
    		 UpdateLevel = false;
    	 }
     }
     
     //STUDENTS REGISTER FORM.
     
     public ObservableList<studentsBio> addStudentsListData(){  //addStudentsListData: object to add students data
     	   ObservableList<studentsBio> listStudents = FXCollections.observableArrayList();
     	   
     	   String sql = "SELECT * FROM studentsbio";
     	   connect = database.connectDb();
     	 
     	 try {
     		 studentsBio studentsData;
 			prepare = connect.prepareStatement(sql);
 			result = prepare.executeQuery();
 			
 			while(result.next()) {
 				studentsData = new studentsBio(result.getString("firstName")
 						,result.getString("middleName")
 						, result.getString("lastName")
 						, result.getString("religion")
 						, result.getDate("DOB")
 						, result.getString("studentNIN")
 						, result.getString("studentDistrict")
 						, result.getString("studentSubcounty")
 						, result.getString("studentCounty")
 						, result.getString("studentParish")
 						, result.getString("studentEmail")
 						, result.getString("studentGender")
 						, result.getString("guardian1Name")
 						, result.getString("guardian1NIN")
 						, result.getString("guardian1Contact1")
 						, result.getString("guardian1Contact2")
 						, result.getString("guardian1District")
 						, result.getString("guardian1Subcounty")
 						, result.getString("guardian1County")
 						, result.getString("guardian1Parish")
 						, result.getString("guardian1Village")
 						, result.getString("guardian1Email")
 						, result.getString("guardian1Occupation")
 						, result.getString("guardian2Name")
 						, result.getString("guardian2NIN")
 						, result.getString("guardian2Contact1")
 						, result.getString("guardian2Contact2")
 						, result.getString("guardian2District")
 						, result.getString("guardian2Subcounty")
 						, result.getString("guardian2County")
 						, result.getString("guardian2Parish")
 						, result.getString("guardian2Village")
 						, result.getString("guardian2Email")
 						, result.getString("guardian2Occupation")
 						, result.getString("NSIN")
 						, result.getInt("Alevel")
 						, result.getInt("Olevel")
 						, result.getString("prevCourse")
 						, result.getInt("courseYear")
 						, result.getString("emergencyName")
 						, result.getString("emergencyContact1")
 						, result.getString("emergencyContact2")
 						, result.getString("relationship")
 						, result.getString("physicianContact")
 						, result.getString("medConditions")
 						, result.getString("medication")
 						, result.getString("medProcedures")
 						, result.getString("specialNeeds")
 						, result.getString("studentContact1")
 						, result.getString("studentContact2")
 						, result.getString("courseTaken")
 						, result.getString("courseLevel")
 						, result.getString("yearCourse")
 						, result.getString("courseSemister"));
 						
 				listStudents.add(studentsData);
 						
 			}
 		} catch (SQLException e) {e.printStackTrace();}
 		     return listStudents;
     }
    
     private ObservableList<studentsBio> addStudentsList = FXCollections.observableArrayList();// Object to show lists on the table
     //Method to add data to the table view...
     public void addStudentsShowListData() {
     	addStudentsList = addStudentsListData();
     	register_nsin_col.setCellValueFactory(new PropertyValueFactory<>("NSIN"));
     	register_Fname_col.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
     	register_Lname_col.setCellValueFactory(new PropertyValueFactory<>("LastName"));
     	register_contact_col.setCellValueFactory(new PropertyValueFactory<>("StudentContact1"));
     	register_Age_col.setCellValueFactory(cellData -> {Integer age = cellData.getValue().getAge();return new SimpleObjectProperty<>(age != null ? age : null);});  //Method to calculate age!
     	register_gender_col.setCellValueFactory(new PropertyValueFactory<>("StudentGender"));
     	register_religion_col.setCellValueFactory(new PropertyValueFactory<>("Religion"));
     	register_tableView.setItems(addStudentsList);
     }
   
     //Method to add data to details View.
      public void addToListView() {    	
     	addStudentsList = addStudentsListData();
         details_nsin_col.setCellValueFactory(new PropertyValueFactory<>("NSIN"));
         details_Fname_col.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
         details_Lname_col.setCellValueFactory(new PropertyValueFactory<>("LastName"));
         details_contact_col.setCellValueFactory(new PropertyValueFactory<>("StudentContact1"));
         details_Age_col.setCellValueFactory(new PropertyValueFactory<>("Age"));  //Method to calculate age
         details_gender_col.setCellValueFactory(new PropertyValueFactory<>("StudentGender"));
     	details_religion_col.setCellValueFactory(new PropertyValueFactory<>("Religion"));
     	details_tableView.setItems(addStudentsList);
     }
     
     //Method to auto detect Selected Student
     public void addStudentsSelected(){
     	studentsBio studentsData = register_tableView.getSelectionModel().getSelectedItem();
     	int num = register_tableView.getSelectionModel().getSelectedIndex();
     	if((num -1) < -1) {return;}
     	register_fname.setText(studentsData.getFirstName());
     	register_middleName.setText(studentsData.getMiddleName());
     	register_LName.setText(studentsData.getLastName());
     	register_religion.setText(studentsData.getReligion());
     	register_DOB.setValue(LocalDate.parse(String.valueOf(studentsData.getDOB())));  // Date converted to String
     	register_NIN.setText(studentsData.getstudentNIN());
     	register_district.setText(studentsData.getstudentNIN());
     	register_subcounty.setText(studentsData.getstudentSubcounty());
     	register_county.setText(studentsData.getstudentCounty());
     	register_gender.setPromptText(studentsData.getStudentGender());
     	register_email.setText(studentsData.getstudentEmail());
     	register_parish.setText(studentsData.getstudentParish());
     	// Guardian 1 information
     	register_gardianName1.setText(studentsData.getguardian1Name());
     	register_gardian1_nin.setText(studentsData.getguardian1NIN());
     	register_gardian1_parish.setText(studentsData.getguardian1Parish());
     	register_gardian1_contact1.setText(String.valueOf(studentsData.getguardian1Contact1()));  // Integer
     	register_gardian1_occupation.setText(studentsData.getguardian1Occupation());
     	register_gardian1_district.setText(studentsData.getguardian1District());
     	register_gardian1_subcounty.setText(studentsData.getguardian1Subcounty());
     	register_gardian1_county.setText(studentsData.getguardian1County());
     	register_gardian1_village.setText(studentsData.getguardian1Village());
     	register_gardian1_email.setText(studentsData.getguardian1Email());
     	register_gardian1_contact2.setText(String.valueOf(studentsData.getguardian1Contact2()));  // Integer
     	// Guardian 2 information
     	register_gardian2_name.setText(studentsData.getguardian2Name());
     	register_gardian2_nin.setText(studentsData.getguardian2NIN());
     	register_gardian2_parish.setText(studentsData.getguardian2Parish());
     	register_gardian2_contact1.setText(String.valueOf(studentsData.getguardian2Contact1()));  // Integer
     	register_gardian2_occupation.setText(studentsData.getguardian2Occupation());
     	register_gardian2_district.setText(studentsData.getguardian2District());
     	register_gardian2_subcounty.setText(studentsData.getguardian2Subcounty());
     	register_gardian2_county.setText(studentsData.getguardian2County());
     	register_gardian2_village.setText(studentsData.getguardian2Village());
     	register_gardian2_email.setText(studentsData.getguardian2Email());
     	register_gardian2_contact2.setText(String.valueOf(studentsData.getguardian2Contact2()));  // Integer
     	// Academic information
     	register_NSIN.setText(studentsData.getNSIN());
     	register_Alevel.setText(String.valueOf(studentsData.getAlevel()));  // Integer
     	register_Olevel.setText(String.valueOf(studentsData.getOlevel()));  // Integer
     	register_doneCourse.setText(studentsData.getprevCourse());
     	register_year_done.setText(String.valueOf(studentsData.getCourseYear()));
     	// Emergency contact information
     	register_emergency_name.setText(studentsData.getemergencyName());
     	register_emrgency_contact1.setText(String.valueOf(studentsData.getemergencyContact1()));  // Integer
     	register_emrgency_contact2.setText(String.valueOf(studentsData.getemergencyContact2()));  // Integer
     	register_relationship.setText(studentsData.getrelationship());
     	// Medical information
     	register_emergencyProcedures.setText(studentsData.getmedProcedures());
     	register_physician_contact.setText(String.valueOf(studentsData.getphysicianContact()));  // Integer
     	register_medical_conditions.setText(studentsData.getmedConditions());
     	register_current_medication.setText(studentsData.getmedication());
     	register_specialNeeds.setText(studentsData.getspecialNeeds());
     	register_student_contact1.setText(String.valueOf(studentsData.getStudentContact1()));
     	register_student_contact2.setText(String.valueOf(studentsData.getstudentContact2()));
     	register_courseTaken.setPromptText(studentsData.getCourseTaken());
     	register_courseLevel.setPromptText(studentsData.getCourseLevel());
     	register_courseYear.setPromptText(studentsData.getYearCourse());
     	register_semester.setPromptText(studentsData.getCourseSemister());
     }
     
    //-------------------------------------------------------------------------------------------------------------
    //java.sql.Date DOB = java.sql.Date.valueOf(register_DOB.getValue());
    // Add students Method. this is by clicking the add 
     public void addStudents() { 
     	String insertData = "INSERT INTO studentsbio (firstName, middleName, lastName, religion, DOB, studentNIN, studentDistrict, studentSubcounty, studentCounty, studentParish, studentEmail, studentGender,  guardian1Name, guardian1NIN, guardian1Contact1, guardian1Contact2, guardian1District, guardian1Subcounty, guardian1County, guardian1Parish, guardian1Village, guardian1Email, guardian1Occupation, guardian2Name, guardian2NIN, guardian2Contact1, guardian2Contact2, guardian2District, guardian2Subcounty, guardian2County, guardian2Parish, guardian2Village, guardian2Email, guardian2Occupation, NSIN, Alevel, Olevel, prevCourse, courseYear, emergencyName, emergencyContact1, emergencyContact2, relationship, physicianContact, medConditions, medication, medProcedures, specialNeeds, studentContact1, studentContact2,courseTaken,courseLevel,yearCourse,courseSemister )  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
     			+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
     	           connect = database.connectDb();
     	    try {
     	    	
     	    	Alert alert;
     	    	boolean IsEmpty = false;
     	    	if(register_fname.getText().isEmpty()) {
     	    		register_fname.setStyle("-fx-border-color: red;-fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_fname.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_LName.getText().isEmpty()) {
     	    		register_LName.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_LName.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_NSIN.getText().isEmpty()) {
     	    		register_NSIN.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_NSIN.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_gender.getSelectionModel().isEmpty()) {
     	    		register_gender.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_gender.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_DOB.getValue() == null) {
     	    		register_DOB.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_DOB.setStyle("");
     	    		
     	    	}
     	    	
     	    	
     	    	if(register_district.getText().isEmpty()) {
     	    		register_district.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_district.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_courseTaken.getValue() == null) {
     	    		register_courseTaken.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_courseTaken.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_courseLevel.getValue() == null) {
     	    		register_courseLevel.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_courseLevel.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_courseYear.getValue() == null) {
     	    		register_courseYear.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_courseYear.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(register_semester.getValue() == null) {
     	    		register_semester.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");
     	    		IsEmpty = true;
     	    	} else {
     	    		register_semester.setStyle("");
     	    		
     	    	}
     	    	
     	    	if(IsEmpty){
     	    		alert = new Alert(AlertType.ERROR);
     	    		alert.setTitle("Error Message");
     	    		alert.setHeaderText(null);
     	    		alert.setContentText("Please fill all compulsory fields");
     	    		alert.showAndWait();
     	    		
     	    	}else {
     	    		// Checks if The data is already available in the data base
     	    		String CheckData = "SELECT NSIN FROM studentsbio WHERE NSIN = '"
     	    				+register_NSIN.getText()+"'";  
     	    		statement = connect.createStatement();
     	    		System.out.println("Checking data...");
     	    		result = statement.executeQuery(CheckData);
     	    		
     	    		if(result.next()) {
     	    			alert = new Alert(AlertType.WARNING);
     	    			alert.setTitle("Warning");
     	    			alert.setHeaderText(null);
     	    			alert.setContentText("Students NSIN:"+register_NSIN.getText()+"Already Registered!");
     	    			alert.showAndWait();
     	    		}else {
     	    			 prepare = connect.prepareStatement(insertData);
     	     	    	 prepare.setString(1, register_fname.getText());
     	     	    	 prepare.setString(2, register_middleName.getText());
     	     	    	 prepare.setString(3, register_LName.getText());
     	     	    	 prepare.setString(4, register_religion.getText());
     	     	    	 
     	     	    	 if(register_DOB.getValue() == null) {
     	     	    		 prepare.setNull(5, java.sql.Types.DATE);
     	     	    		
     	     	    	 }else {
//     	     	    		 java.sql.Date sqlDate = java.sql.Date.valueOf(register_DOB.getValue());
//     	     	    		 prepare.setDate(5,sqlDate );
     	     	    		prepare.setString(5, String.valueOf(register_DOB.getValue()));
     	     	    	 }
                          // Potential Bug @kelvis
     	     	    	 prepare.setString(6, register_NIN.getText());
     	     	    	 prepare.setString(7, register_district.getText());
     	     	    	 prepare.setString(8, register_subcounty.getText());
     	     	    	 prepare.setString(9, register_county.getText());
     	     	    	 prepare.setString(10, register_parish.getText());
     	     	    	 prepare.setString(11, register_email.getText());
     	     	    	 prepare.setString(12, (String)register_gender.getSelectionModel().getSelectedItem());  //This to all prompted Values
     	     	    	 prepare.setString(13, register_gardianName1.getText());
     	     	    	 prepare.setString(14, register_gardian1_nin.getText());
     	     	    	 prepare.setString(15, register_gardian1_contact1.getText());
     	     	    	 prepare.setString(16, register_gardian1_contact2.getText());
     	     	    	 prepare.setString(17, register_gardian1_district.getText());
     	     	    	 prepare.setString(18, register_gardian1_subcounty.getText());
     	     	    	 prepare.setString(19, register_gardian1_county.getText());
     	     	    	 prepare.setString(20, register_gardian1_parish.getText());
     	     	    	 prepare.setString(21, register_gardian1_village.getText());
     	     	    	 prepare.setString(22, register_gardian1_email.getText());
     	     	    	 prepare.setString(23, register_gardian1_occupation.getText());
     	     	    	 prepare.setString(24, register_gardian2_name.getText());
     	     	    	 prepare.setString(25, register_gardian2_nin.getText());
     	     	    	 prepare.setString(26, register_gardian2_contact1.getText());
     	     	    	 prepare.setString(27, register_gardian2_contact2.getText());
     	     	    	 prepare.setString(28, register_gardian2_district.getText());
     	     	    	 prepare.setString(29, register_gardian2_subcounty.getText());
     	     	    	 prepare.setString(30, register_gardian2_county.getText());
     	     	    	 prepare.setString(31, register_gardian2_parish.getText());
     	     	    	 prepare.setString(32, register_gardian2_village.getText());
     	     	    	 prepare.setString(33, register_gardian2_email.getText());
     	     	    	 prepare.setString(34, register_gardian2_occupation.getText());
     	     	    	 prepare.setString(35, register_NSIN.getText());
     	     	    	 
     	     	    	 String ALevel = register_Alevel.getText().trim();
     	     	    	 if(ALevel.isEmpty()) {
     	     	    		 prepare.setNull(36, java.sql.Types.INTEGER);
     	     	    	 }else {
     	     	    		 try {
     	     	    			 prepare.setInt(36,Integer.parseInt(ALevel));
     	     	    		 }catch(NumberFormatException e) {
     	     	    			register_Alevel.setStyle("-fx-border-color:red");
     	     	    			ALERT.showError("Input must be a digit. ie 96");
     	     	    			return;
     	     	    		 }
     	     	    	 }
     	     	    	 
     	     	    	 String OLevel = register_Olevel.getText().trim();
     	     	    	 if(OLevel.isEmpty()) {
     	     	    		 prepare.setNull(37, java.sql.Types.INTEGER);
     	     	    	 }else {
     	     	    		 try {
     	     	    			 prepare.setInt(37, Integer.parseInt(OLevel));
     	     	    		 }catch(NumberFormatException e) {
     	     	    			register_Olevel.setStyle("-fx-border-color:red");
     	     	    			ALERT.showError("Input must be a digit. ie 97");
     	     	    			return;
     	     	    		 }
     	     	    	 }
     	     	    	 
     	     	    	 prepare.setString(38, register_doneCourse.getText());
     	     	    	 
     	     	    	 String Year = register_year_done.getText().trim();
     	     	    	 if(Year.isEmpty()) {
     	     	    		 prepare.setNull(39, java.sql.Types.INTEGER);
     	     	    	 }else {
     	     	    		 try {
     	     	    			 prepare.setInt(39, Integer.parseInt(Year));
     	     	    		 }catch(NumberFormatException e) {
     	     	    			register_doneCourse.setStyle("-fx-border-color:red");
     	     	    			ALERT.showError("Enter a valid year eg: 2025");
     	     	    			return;
     	     	    		 }
     	     	    	 }
     	     	    	 prepare.setString(40, register_emergency_name.getText());
     	     	    	 prepare.setString(41, register_emrgency_contact1.getText());
     	     	    	 prepare.setString(42, register_emrgency_contact2.getText());
     	     	    	 prepare.setString(43, register_relationship.getText());
     	     	    	 prepare.setString(44, register_physician_contact.getText());
     	     	    	 prepare.setString(45, register_medical_conditions.getText());
     	     	    	 prepare.setString(46, register_current_medication.getText());
     	     	    	 prepare.setString(47, register_emergencyProcedures.getText());
     	     	    	 prepare.setString(48, register_specialNeeds.getText());
     	     	    	 prepare.setString(49, register_student_contact1.getText());
     	     	    	 prepare.setString(50, register_student_contact2.getText());
     	     	    	 prepare.setString(51, register_courseTaken.getSelectionModel().getSelectedItem());
     	     	    	 prepare.setString(52, register_courseLevel.getSelectionModel().getSelectedItem());
     	     	    	 prepare.setString(53, register_courseYear.getSelectionModel().getSelectedItem());
     	     	    	 prepare.setString(54, register_semester.getSelectionModel().getSelectedItem());
     	     	    	 prepare.executeUpdate();
     	     	    	 
     	     	    	 //Inserting Students Grades
     	     	    	 //Sets students grades to 0 when a student is registered.
     	     	    	 String insertGrades = "INSERT INTO students_grades (NSIN, studentsName, sem1_p1, sem1_p2, sem1_p3, sem1_p4, sem2_p1, sem2_p2,"
     	     	    	 		+ " sem2_p3, sem2_p4,sem3_p1, sem3_p2, sem3_p3, sem3_p4, sem4_p1, sem4_p2, sem4_p3, sem4_p4, sem5_p1, sem5_p2, sem5_p3, "
     	     	    	 		+ "sem5_p4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     	     	    	PreparedStatement prepareGrades = connect.prepareStatement(insertGrades);
     	     	    	prepareGrades.setString(1, register_NIN.getText());  // Caution!
     	     	    	prepareGrades.setString(2, register_fname.getText() +" "+register_middleName.getText()+" "+ register_LName.getText());
     	     	    	prepareGrades.setString(3, "0");
     	     	    	prepareGrades.setString(4, "0");
     	     	    	prepareGrades.setString(5, "0");
     	     	    	prepareGrades.setString(6, "0");
     	     	    	prepareGrades.setString(7, "0");
     	     	    	prepareGrades.setString(8, "0");
     	     	    	prepareGrades.setString(9, "0");
     	     	    	prepareGrades.setString(10, "0");
     	     	    	prepareGrades.setString(11, "0");
     	     	    	prepareGrades.setString(12, "0");
     	     	    	prepareGrades.setString(13, "0");
     	     	    	prepareGrades.setString(14, "0");
     	     	    	prepareGrades.setString(15, "0");
     	     	    	prepareGrades.setString(16, "0");
     	     	    	prepareGrades.setString(17, "0");
     	     	    	prepareGrades.setString(18, "0");
     	     	    	prepareGrades.setString(19, "0");
     	     	    	prepareGrades.setString(20, "0");
     	     	    	prepareGrades.setString(21, "0");
     	     	    	prepareGrades.setString(22, "0");
     	     	    	prepareGrades.executeUpdate();
                          alert = new Alert(AlertType.CONFIRMATION);
                          alert.setTitle("Confirmation Message");
                          alert.setHeaderText(null);
                          alert.setContentText("Student has been Added Successfully");
     	     	    	 alert.showAndWait();
     	     	    	addStudentsShowListData();
     	     	    	addStudentsShowListData();//load students 
     	     	    	clearInputs();//Clear the text
     	    		}
     	    	}
     	    }catch(Exception e) {e.printStackTrace();
     	    System.err.println("SQL Error: " + e.getMessage());
     	    System.err.println("Failed query: " + insertData);
     	    }
        }
    //#################################################################################################
    // Clear Method
    
     public void clearInputs() {
     	register_fname.setText("");
     	register_middleName.setText("");
     	register_LName.setText("");
     	register_religion.setText("");
     	register_DOB.setValue(null);
     	register_NIN.setText("");
     	register_district.setText("");
     	register_subcounty.setText("");
     	register_county.setText("");
     	register_parish.setText("");
     	register_gender.getSelectionModel().clearSelection();
     	register_email.setText("");
     	register_gardianName1.setText("");
     	register_gardian1_contact1.setText("");
     	register_gardian1_contact2.setText("");
     	register_Alevel.setText("");
     	register_Olevel.setText("");
     	register_doneCourse.setText("");
     	register_year_done.setText("");
     	register_emergency_name.setText("");
     	register_emrgency_contact1.setText("");
     	register_emrgency_contact2.setText("");
     	register_relationship.setText("");
     	register_physician_contact.setText("");
     	register_medical_conditions.setText("");
     	register_current_medication.setText("");
     	register_emergencyProcedures.setText("");
     	register_specialNeeds.setText("");
     	register_student_contact1.setText("");
     	register_student_contact2.setText("");
     	register_gardian1_nin.setText("");
     	register_gardian1_district.setText("");
     	register_gardian1_subcounty.setText("");
     	register_gardian1_county.setText("");
     	register_gardian1_parish.setText("");
     	register_gardian1_village.setText("");
     	register_gardian1_email.setText("");
     	register_gardian1_occupation.setText("");
     	register_gardian2_name.setText("");
     	register_gardian2_nin.setText("");
     	register_gardian2_contact1.setText("");
     	register_gardian2_contact2.setText("");
     	register_gardian2_district.setText("");
     	register_gardian2_subcounty.setText("");
     	register_gardian2_county.setText("");
     	register_gardian2_parish.setText("");
     	register_gardian2_village.setText("");
     	register_gardian2_email.setText("");
     	register_gardian2_occupation.setText("");
     	register_NSIN.setText("");
     	register_courseTaken.getSelectionModel().clearSelection();
     	register_courseLevel.getSelectionModel().clearSelection();
     	register_courseYear.getSelectionModel().clearSelection();
     	register_semester.getSelectionModel().clearSelection();
     	
     	register_fname.setStyle("");
 	    register_LName.setStyle("");
 	    register_NSIN.setStyle("");
 	    register_courseTaken.setStyle("");
 	    register_courseLevel.setStyle("");
 	    register_courseYear.setStyle("");
 	    register_semester.setStyle("");    
     }
    
    // THE METHOD TO UPDATE THE DATA IN THE DATABASE
     public void updateStudents() {
     	String ALevel = register_Alevel.getText().trim();
     	String OLevel = register_Olevel.getText().trim();
     	String Year = register_year_done.getText().trim();
     	String updateData = "UPDATE studentsbio SET firstName = '"+register_fname.getText()+"',middleName ='"+ register_middleName.getText()+"',"
     			+ "lastName ='"+register_LName.getText()+"',religion ='"+register_religion.getText()+"',DOB = '"+register_DOB.getValue()+"',"
     					+ "studentNIN = '"+register_NIN.getText()+"',studentDistrict = '"+register_district.getText()+"',studentSubcounty = '"+register_subcounty.getText()+"',"
     					+ "studentCounty = '"+register_county.getText()+"',studentParish = '"+register_parish.getText()+"', studentEmail = '"+register_email.getText()+"',"
     					+ "studentGender = '"+(String)register_gender.getSelectionModel().getSelectedItem()+"',guardian1Name='"+register_gardianName1.getText()+"',"
     					+ "guardian1NIN = '"+register_gardian1_nin.getText()+"',guardian1Contact1='"+register_gardian1_contact1.getText()+"',guardian1Contact2 ='"+register_gardian2_contact1.getText()+"',"
     					+ "guardian1District = '"+register_gardian1_district.getText()+"',guardian1Subcounty = '"+register_gardian1_subcounty.getText()+"',guardian1County='"+register_gardian1_county.getText()+"',"
     					+ "guardian1Parish='"+register_gardian1_parish.getText()+"',guardian1Village='"+register_gardian1_village.getText()+"',guardian1Email='"+register_gardian1_email.getText()+"',"
     					+ "guardian1Occupation='"+register_gardian1_occupation.getText()+"',guardian2Name='"+ register_gardian2_name.getText()+"',guardian2NIN='"+register_gardian2_nin.getText()+"',"
     					+ "guardian2Contact1='"+register_gardian2_contact1.getText()+"',guardian2Contact2='"+register_gardian2_contact2.getText()+"',guardian2District='"+register_gardian2_district.getText()+"',"
     					+ "guardian2Subcounty='"+register_gardian2_subcounty.getText()+"',guardian2County='"+register_gardian2_county.getText()+"',guardian2Parish='"+register_gardian2_parish.getText()+"',"
     					+ "guardian2Village='"+register_gardian2_village.getText()+"',guardian2Email='"+register_gardian2_email.getText()+"',guardian2Occupation='"+register_gardian2_occupation.getText()+"',"
     					+ "Alevel='"+Integer.parseInt(ALevel)+"',Olevel='"+Integer.parseInt(OLevel)+"',prevCourse='"+register_doneCourse.getText()+"',"
     					+ "courseYear='"+Integer.parseInt(Year)+"',emergencyName='"+register_emergency_name.getText()+"',emergencyContact1='"+register_emrgency_contact1.getText()+"',"
     					+ "emergencyContact2='"+register_emrgency_contact2.getText()+"',relationship='"+register_relationship.getText()+"',physicianContact='"+register_physician_contact.getText()+"',"
     					+ "medConditions='"+register_medical_conditions.getText()+"',medication='"+register_current_medication.getText()+"',medProcedures='"+register_emergencyProcedures.getText()+"',"
     					+ "specialNeeds='"+register_specialNeeds.getText()+"',studentContact1='"+register_student_contact1.getText()+"',studentContact2='"+register_student_contact2.getText()+"',"
     					+ "courseTaken='"+register_courseTaken.getSelectionModel().getSelectedItem()+"',courseLevel='"+register_courseLevel.getSelectionModel().getSelectedItem()+"',"
     					+ "yearCourse='"+register_courseYear.getSelectionModel().getSelectedItem()+"',courseSemister='"+register_semester.getSelectionModel().getSelectedItem()+"' WHERE NSIN = '"+register_NSIN.getText()+"'";
                 
     	        connect = database.connectDb();
     	        try {
     	        	Alert alert;
     	        	if(register_NSIN.getText().isEmpty()) {
     	        	    		register_NSIN.setStyle("-fx-border-color: red; -fx-border-width: 0 0 0.8px 0;");

     	        	    		alert = new Alert(AlertType.ERROR);
     	        	    		alert.setTitle("Error Message");
     	        	    		alert.setHeaderText(null);
     	        	    		alert.setContentText("Please fill all Required fields");
     	        	    		alert.showAndWait();    	
     	        	  
         	    		}else {
         	    			    register_NSIN.setStyle(""); 
 	        	    			//Prompt Confirmation for Update
 	        	    			alert = new Alert(AlertType.CONFIRMATION);
 	        	    			alert.setTitle("Confirmation Message");
 	        	    			alert.setHeaderText(null);
 	        	    			alert.setContentText("Are you sure about this?\n Student NSIN: "+register_NSIN.getText()+" To be UPDATED!");
 	        	    			Optional<ButtonType> option = alert.showAndWait();
         	    			
         	    			if(option.get().equals(ButtonType.OK)) {
         	    				prepare = connect.prepareStatement(updateData);
         	    				statement = connect.createStatement();
             	    			statement.executeUpdate(updateData);
             	    			
             	    			alert = new Alert(AlertType.INFORMATION);
             	    			alert.setTitle("Information Message");
             	    			alert.setHeaderText(null);
             	    			alert.setContentText("Data update Succesfull!");
             	    			alert.showAndWait();
             	     	    	addStudentsShowListData(); //load students 
             	     	    	clearInputs(); //Clear the text
             	    			
         	    			}else return;	
         	    		}
     	        	
     	        }catch(Exception e) {e.printStackTrace();
     	        Alert alert = new Alert(Alert.AlertType.ERROR);
     	        alert.setTitle("Error");
     	        alert.setHeaderText(null);
     	        alert.setContentText("Failed to update data: " + e.getMessage());
     	        alert.showAndWait();
     	        }
      }
    
    //DELETE STUDENTS BY NSIN NO.
     public void delete() {
    	    String deleteData = "DELETE FROM studentsbio WHERE NSIN = '"+register_NSIN.getText()+"'";

    	    connect = database.connectDb();

    	    try {
    	        Alert alert;

    	        if (register_fname.getText().isEmpty() || register_LName.getText().isEmpty() || register_NSIN.getText().isEmpty()) {
    	            alert = new Alert(AlertType.ERROR);
    	            alert.setTitle("Error Message");
    	            alert.setHeaderText(null);
    	            alert.setContentText("Please select the information to delete.");
    	            alert.showAndWait();
    	        } else {
    	            alert = new Alert(AlertType.CONFIRMATION);
    	            alert.setTitle("Confirmation Message");
    	            alert.setHeaderText(null);
    	            alert.setContentText("Are you sure you want to delete Student with NSIN: " +register_NSIN.getText() + " ?");
    	            Optional<ButtonType> option = alert.showAndWait();

    	            if (option.get().equals(ButtonType.OK)) {
    	                // Delete grades first
    	                statement = connect.prepareStatement(deleteData);
    	                statement.executeUpdate(deleteData);

    	                String checkData = "SELECT NSIN FROM students_grades "
                                + "WHERE NSIN = '" + register_NSIN.getText()+ "'";
    	                prepare = connect.prepareStatement(checkData);
    	                result = prepare.executeQuery();
    	                if (result.next()) {
                            String deleteGrade = "DELETE FROM students_grades WHERE "
                                    + "studentNum = '" + register_NSIN.getText() + "'";

                            statement = connect.createStatement();
                            statement.executeUpdate(deleteGrade);
                        }
    	                
    	                alert = new Alert(AlertType.INFORMATION);
    	                alert.setTitle("Information Message");
    	                alert.setHeaderText(null);
    	                alert.setContentText("Student Deleted Successfully!");
    	                alert.showAndWait();

    	                showGradeList();
    	                addStudentsShowListData();
    	                clearInputs();
    	            }else return;
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

     }
    
    //Search Functionality...
    public void studentSearch() {
    	
    	FilteredList<studentsBio> filteredD = new FilteredList<>(addStudentsList, b -> true);
    	register_search.textProperty().addListener((Observable, oldValue, newValue) ->{
    		
    		filteredD.setPredicate(studentsData ->{  // If search is empty show, everything
    			if(newValue == null || newValue.isEmpty() || newValue.isBlank()) {
    				return true;
    			}
    			String searchKey = newValue.toLowerCase(); // Change everything to LowerCase
    			
    			if(studentsData.getNSIN().toString().contains(searchKey)) {
    				return true;
    			}else if(studentsData.getFirstName().toLowerCase().contains(searchKey)) {
    				return true;
    			}else if(studentsData.getStudentGender().toLowerCase().contains(searchKey)) {
                    return true;
    			}else if(studentsData.getReligion().toLowerCase().contains(searchKey)) {
    				return true;
    			}else if(studentsData.getMiddleName().toLowerCase().contains(searchKey)) {
                    return true;
    			}else if(studentsData.getLastName().toLowerCase().contains(searchKey)) {
    				return true;
    			}else {return false;}
    			
    		});
    	});
    	SortedList<studentsBio> shortList = new SortedList<>(filteredD);
    	shortList.comparatorProperty().bind(register_tableView.comparatorProperty());
    	register_tableView.setItems(shortList);
    }
    
    public void listSearch() {
    	FilteredList<studentsBio> listSearch =new FilteredList<>(addStudentsList, e -> true);
    	detailsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
    		listSearch.setPredicate(predicateListData ->{
    			if(newValue == null || newValue.isEmpty()) {
    				return true;
    			}
    			String SKey = newValue.toLowerCase();
    			if(predicateListData.getNSIN().toLowerCase().contains(SKey)){
    				return true;
    			}else if(predicateListData.getFirstName().toLowerCase().contains(SKey)) {
    				return true;
    			}else if(predicateListData.getReligion().toLowerCase().contains(SKey)) {
    				return true;
    			}else if(predicateListData.getMiddleName().toLowerCase().contains(SKey)) {
    				return true;
    			}else if(predicateListData.getLastName().toLowerCase().contains(SKey)) {
    				return true;
    			}else if(predicateListData.getAge().toString().contains(SKey)) {
    				return true;
    			}else {return false;}
    		});
    	});
    	
    	SortedList<studentsBio> sortedL = new SortedList<>(listSearch);
    	sortedL.comparatorProperty().bind(details_tableView.comparatorProperty());
    	details_tableView.setItems(sortedL);
    }

 // The grades and Staff;
    public ObservableList<studentsBio> gradesListData(){
 	      ObservableList<studentsBio> gradeList = FXCollections.observableArrayList();
 	      
 	      String SQL = "SELECT * FROM students_grades";
 	      connect = database.connectDb();
 	      
 	      try {
 	    	  studentsBio studentD;
 	    	  prepare = connect.prepareStatement(SQL);
 	    	  result = prepare.executeQuery();
 	    	   while(result.next()) {
 	    		   studentD = new studentsBio(result.getString("NSIN")
 	    				   ,result.getString("StudentsName")
 	    				   ,result.getInt("Sem1_p1")
 	    				   ,result.getInt("Sem1_p2")
 	    				   ,result.getInt("Sem1_p3")
 	    				   ,result.getInt("Sem1_p4")
 	    				   ,result.getInt("Sem2_p1")
 	    				   ,result.getInt("Sem2_p2")
 	    				   ,result.getInt("Sem2_p3")
 	    				   ,result.getInt("Sem2_p4")
 	    				   ,result.getInt("Sem3_p1")
 	    				   ,result.getInt("Sem3_p2")
 	    				   ,result.getInt("Sem3_p3")
 	    				   ,result.getInt("Sem3_p4")
 	    				   ,result.getInt("Sem4_p1")
 	    				   ,result.getInt("Sem4_p2")
 	    				   ,result.getInt("Sem4_p3")
 	    				   ,result.getInt("Sem4_p4")
 	    				   ,result.getInt("Sem5_p1")
 	    				   ,result.getInt("Sem5_p2")
 	    				   ,result.getInt("Sem5_p3")
 	    				   ,result.getInt("Sem5_p4"));
 	    		   
 	    		   gradeList.add(studentD);
 	    	   }
 	    	  
 	      }catch(Exception e) {e.printStackTrace();}
 	      
 	      return gradeList;
    }

    private ObservableList<studentsBio> Grades;
    public void showGradeList() {
 	   Grades = gradesListData();
 	   Table_nsin.setCellValueFactory(new PropertyValueFactory<>("NSIN"));
 	   Table_name.setCellValueFactory(new PropertyValueFactory<>("StudentsName"));
 	   Table_year1_sem1_p1.setCellValueFactory(new PropertyValueFactory<>("sem1_p1"));
 	   Table_year1_sem1_p2.setCellValueFactory(new PropertyValueFactory<>("sem1_p2"));
 	   Table_year1_sem1_p3.setCellValueFactory(new PropertyValueFactory<>("sem1_p3"));
 	   Table_year1_sem1_p4.setCellValueFactory(new PropertyValueFactory<>("sem1_p4"));
 	   Table_year1_sem2_p1.setCellValueFactory(new PropertyValueFactory<>("sem2_p1"));
 	   Table_year1_sem2_p2.setCellValueFactory(new PropertyValueFactory<>("sem2_p2"));
 	   Table_year1_sem2_p3.setCellValueFactory(new PropertyValueFactory<>("sem2_p3"));
 	   Table_year1_sem2_p4.setCellValueFactory(new PropertyValueFactory<>("sem2_p4"));
 	   Table_year2_sem1_p1.setCellValueFactory(new PropertyValueFactory<>("sem3_p1"));
 	   Table_year2_sem1_p2.setCellValueFactory(new PropertyValueFactory<>("sem3_p2"));
 	   Table_year2_sem1_p3.setCellValueFactory(new PropertyValueFactory<>("sem3_p3"));
 	   Table_year2_sem1_p4.setCellValueFactory(new PropertyValueFactory<>("sem3_p4"));
 	   Table_year2_sem2_p1.setCellValueFactory(new PropertyValueFactory<>("sem4_p1"));
 	   Table_year2_sem2_p2.setCellValueFactory(new PropertyValueFactory<>("sem4_p2"));
 	   Table_year2_sem2_p3.setCellValueFactory(new PropertyValueFactory<>("sem4_p3"));
 	   Table_year2_sem2_p4.setCellValueFactory(new PropertyValueFactory<>("sem4_p4"));
 	   Table_year3_sem1_p1.setCellValueFactory(new PropertyValueFactory<>("sem5_p1"));
 	   Table_year3_sem1_p2.setCellValueFactory(new PropertyValueFactory<>("sem5_p2"));
 	   Table_year3_sem1_p3.setCellValueFactory(new PropertyValueFactory<>("sem5_p3"));
 	   Table_year3_sem1_p4.setCellValueFactory(new PropertyValueFactory<>("sem5_p4"));
 	   gradeTable.setItems(Grades);
    
    
    }
    
  //Grades Select
    public void gradeSelect() {
 	   studentsBio studentsData = gradeTable.getSelectionModel().getSelectedItem();
 	   int Num = gradeTable.getSelectionModel().getSelectedIndex();
 	   
 	   if((Num - 1) < -1) { return;}
 		   gradeForm_NSIN.setText(studentsData.getNSIN());
 		   gradeForm_NAME.setText(studentsData.getStudentsName());
 		   year1_sem1_p1.setText(String.valueOf(studentsData.getSem1_p1()));
 		   year1_sem1_p2.setText(String.valueOf(studentsData.getSem1_p2()));
 		   year1_sem1_p3.setText(String.valueOf(studentsData.getSem1_p3()));
 		   year1_sem1_p4.setText(String.valueOf(studentsData.getSem1_p4()));
 		   year1_sem2_p1.setText(String.valueOf(studentsData.getSem2_p1()));
 		   year1_sem2_p2.setText(String.valueOf(studentsData.getSem2_p2()));
 		   year1_sem2_p3.setText(String.valueOf(studentsData.getSem2_p3()));
 		   year1_sem2_p4.setText(String.valueOf(studentsData.getSem2_p4()));
 		   year2_sem_p1.setText(String.valueOf(studentsData.getSem3_p1()));
 		   year2_sem_p2.setText(String.valueOf(studentsData.getSem3_p2()));
 		   year2_sem_p3.setText(String.valueOf(studentsData.getSem3_p3()));
 		   year2_sem_p4.setText(String.valueOf(studentsData.getSem3_p4()));
 		   year2_sem2_p1.setText(String.valueOf(studentsData.getSem4_p1()));
 		   year2_sem2_p2.setText(String.valueOf(studentsData.getSem4_p2()));
 		   year2_sem2_p3.setText(String.valueOf(studentsData.getSem4_p3()));
 		   year2_sem2_p4.setText(String.valueOf(studentsData.getSem4_p4()));
 		   year3_sem_p1.setText(String.valueOf(studentsData.getSem4_p1()));
 		   year3_sem_p2.setText(String.valueOf(studentsData.getSem4_p2()));
 		   year3_sem1_p3.setText(String.valueOf(studentsData.getSem4_p3()));
 		   year3_sem2_p4.setText(String.valueOf(studentsData.getSem4_p4()));
    }
    
    public void gradeSearch() {
 	FilteredList<studentsBio> gradeFilter = new FilteredList<>(Grades, e-> true);
 	grade_search.textProperty().addListener((Observable, oldVlaue, newValue) -> {
 		gradeFilter.setPredicate(predicateStudentsGrade ->{
 			if(newValue == null || newValue.isEmpty()) {
 				return true;
 			}
 			
 			String searchKey = newValue.toLowerCase();
 			if(predicateStudentsGrade.getNSIN().toString().contains(searchKey)) {
 				return true;
 			}else if(predicateStudentsGrade.getStudentsName().toString().contains(searchKey)) {
 				return true;
 			}else if(predicateStudentsGrade.getFirstName().toString().contains(searchKey)) {
 				return true;
 			}else if(predicateStudentsGrade.getMiddleName().toString().contains(searchKey)) {
 				return true;
 			}else if(predicateStudentsGrade.getLastName().toString().contains(searchKey)) {
 				return true;
 			}else return false;
 			
 		});
 	});
 	SortedList<studentsBio> sortGrades = new SortedList<>(gradeFilter);
 	sortGrades.comparatorProperty().bind(gradeTable.comparatorProperty());
 	gradeTable.setItems(sortGrades);
    }
    

    public void gradeClear() {
 	   gradeForm_NSIN.setText("");
 	   gradeForm_NAME.setText("");
 	   year1_sem1_p1.setText("");
 	   year1_sem1_p2.setText("");
 	   year1_sem1_p3.setText("");
 	   year1_sem1_p4.setText("");
 	   year1_sem2_p1.setText("");
 	   year1_sem2_p2.setText("");
 	   year1_sem2_p3.setText("");
 	   year1_sem2_p4.setText("");
 	   year2_sem_p1.setText("");
 	   year2_sem_p2.setText("");
 	   year2_sem_p3.setText("");
 	   year2_sem_p4.setText("");
 	   year2_sem2_p1.setText("");
 	   year2_sem2_p2.setText("");
 	   year2_sem2_p3.setText("");
 	   year2_sem2_p4.setText("");
 	   year3_sem_p1.setText("");
 	   year3_sem_p2.setText("");
 	   year3_sem1_p3.setText("");
 	   year3_sem2_p4.setText("");
    }
    
 // Helper to safely convert text to int
    int safeParse(String text) {
        return text.trim().isEmpty() ? 0 : Integer.parseInt(text.trim());
    }
    public void gradeUpdate() {
 	    // Get integer values safely from text fields
 	    int sem1_p1 = safeParse(year1_sem1_p1.getText());
 	    int sem1_p2 = safeParse(year1_sem1_p2.getText());
 	    int sem1_p3 = safeParse(year1_sem1_p3.getText());
 	    int sem1_p4 = safeParse(year1_sem1_p4.getText());
 	    int sem2_p1 = safeParse(year1_sem2_p1.getText());
 	    int sem2_p2 = safeParse(year1_sem2_p2.getText());
 	    int sem2_p3 = safeParse(year1_sem2_p3.getText());
 	    int sem2_p4 = safeParse(year1_sem2_p4.getText());
 	    int sem3_p1 = safeParse(year2_sem_p1.getText());
 	    int sem3_p2 = safeParse(year2_sem_p2.getText());
 	    int sem3_p3 = safeParse(year2_sem_p3.getText());
 	    int sem3_p4 = safeParse(year2_sem_p4.getText());
 	    int sem4_p1 = safeParse(year2_sem2_p1.getText());
 	    int sem4_p2 = safeParse(year2_sem2_p2.getText());
 	    int sem4_p3 = safeParse(year2_sem2_p3.getText());
 	    int sem4_p4 = safeParse(year2_sem2_p4.getText());
 	    int sem5_p1 = safeParse(year3_sem_p1.getText());
 	    int sem5_p2 = safeParse(year3_sem_p2.getText());
 	    int sem5_p3 = safeParse(year3_sem1_p3.getText());
 	    int sem5_p4 = safeParse(year3_sem2_p4.getText());

 	    String studentName = gradeForm_NAME.getText().trim();
 	    String nsin = gradeForm_NSIN.getText().trim();

 	    if (nsin.isEmpty()) {
 	        Alert alert = new Alert(Alert.AlertType.ERROR);
 	        alert.setTitle("Alert Message!");
 	        alert.setHeaderText(null);
 	        alert.setContentText("Please select a Student NSIN.");
 	        alert.showAndWait();
 	        return;
 	    }

 	    String sql = "UPDATE students_grades SET studentsName=?, "
 	            + "sem1_p1=?, sem1_p2=?, sem1_p3=?, sem1_p4=?, "
 	            + "sem2_p1=?, sem2_p2=?, sem2_p3=?, sem2_p4=?, "
 	            + "sem3_p1=?, sem3_p2=?, sem3_p3=?, sem3_p4=?, "
 	            + "sem4_p1=?, sem4_p2=?, sem4_p3=?, sem4_p4=?, "
 	            + "sem5_p1=?, sem5_p2=?, sem5_p3=?, sem5_p4=? "
 	            + "WHERE NSIN=?";

 	    connect = database.connectDb();

 	    try {
 	        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
 	        confirmAlert.setTitle("Confirmation");
 	        confirmAlert.setHeaderText(null);
 	        confirmAlert.setContentText("Are you sure you want to update grades for student: " + nsin + "?");

 	        Optional<ButtonType> option = confirmAlert.showAndWait();

 	        if (option.isPresent() && option.get() == ButtonType.OK) {
 	            PreparedStatement ps = connect.prepareStatement(sql);
 	            ps.setString(1, studentName);
 	            ps.setInt(2, sem1_p1);
 	            ps.setInt(3, sem1_p2);
 	            ps.setInt(4, sem1_p3);
 	            ps.setInt(5, sem1_p4);
 	            ps.setInt(6, sem2_p1);
 	            ps.setInt(7, sem2_p2);
 	            ps.setInt(8, sem2_p3);
 	            ps.setInt(9, sem2_p4);
 	            ps.setInt(10, sem3_p1);
 	            ps.setInt(11, sem3_p2);
 	            ps.setInt(12, sem3_p3);
 	            ps.setInt(13, sem3_p4);
 	            ps.setInt(14, sem4_p1);
 	            ps.setInt(15, sem4_p2);
 	            ps.setInt(16, sem4_p3);
 	            ps.setInt(17, sem4_p4);
 	            ps.setInt(18, sem5_p1);
 	            ps.setInt(19, sem5_p2);
 	            ps.setInt(20, sem5_p3);
 	            ps.setInt(21, sem5_p4);
 	            ps.setString(22, nsin);
 	            ps.executeUpdate();
               
 	            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
 	            successAlert.setTitle("Success");
 	            successAlert.setHeaderText(null);
 	            successAlert.setContentText("Grades updated successfully for NSIN: " + nsin);
 	            successAlert.showAndWait();
 	           showGradeList();
 	           gradeClear();
 	        }
 	    } catch (Exception e) {
 	        e.printStackTrace();
 	        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
 	        errorAlert.setTitle("Error");
 	        errorAlert.setHeaderText(null);
 	        errorAlert.setContentText("An error occurred while updating the grades.");
 	        errorAlert.showAndWait();
 	    }
    }
    
    
    
    private double x = 0;
    private double y = 0;
    // The methods to implement
    
    // the chart methods
    
    public void homeDisplayTotalaenrolledStudents() {
    	String sql = "SELECT COUNT(id) FROM studentsbio";
    	connect = database.connectDb();
    	int countEnrolled = 0;
    	try {
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			countEnrolled = result.getInt("COUNT(id)");
    			
    		}
    		home_total.setText(String.valueOf(countEnrolled));
    		
    	}catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeDisplayFemaleEnrolled() {
    	String sql = "SELECT COUNT(id) FROM studentsbio WHERE studentGender = 'Female'";
    	connect = database.connectDb();
    	try {
    		int countFemale = 0;
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			countFemale = result.getInt("COUNT(id)");
    		}
    		
    		home_female_total.setText(String.valueOf(countFemale)); 
    		
    	}catch(Exception e) {e.printStackTrace();}
    	
    }
    
    public void homeDisplayMaleEnrolled() {
    	String sql = "SELECT COUNT(id) FROM studentsbio WHERE studentGender = 'Male'";
    	connect = database.connectDb();
    	
    	try {
    		int countMale = 0;
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			countMale = result.getInt("COUNT(id)");
    		}
    		home_male_total.setText(String.valueOf(countMale));
    		
    	}catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeDisplayTotalEnrolledChart () {
    	home_total_chart.getData () .clear();
    	
    	String sql = "SELECT courseLevel, COUNT(id) FROM studentsbio WHERE courseLevel IN ('Diploma','Certificate') GROUP BY courseLevel ORDER BY TIMESTAMP(courseLevel) ASC";
    	
    	connect = database.connectDb();
    	
    	
    	
    	try {
    		XYChart.Series chart = new XYChart.Series();
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		while(result.next()) {
    			chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
    		}
    		
    		home_total_chart.getData().add(chart);
    		
    	}catch(Exception e) {e.printStackTrace();}
    	
    }
    
    public void homeDisplayFemaleEnrolledChart() {

    	home_female_chart.getData().clear();

    	String sql = "SELECT courseLevel, COUNT(id) FROM studentsbio WHERE courseLevel IN ('Certificate','Diploma') and studentGender = 'Female' GROUP BY courseLevel ORDER BY TIMESTAMP(courseTaken) ASC";

        connect = DatabaseConnector.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_female_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayMaleEnrolledChart() {
    	home_male_chart.getData().clear();

        String sql = "SELECT courseLevel, COUNT(id) FROM studentsbio WHERE courseLevel IN ('Certificate','Diploma') and studentGender = 'Male' GROUP BY courseLevel ORDER BY TIMESTAMP(courseTaken) ASC";

        connect = DatabaseConnector.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_male_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    //The close window method..
    public void close() {
    	System.exit(0);
    }
    
    //Minimize window method...
    public void minimise() {
    	Stage stage = (Stage)main_form.getScene().getWindow();
    	stage.setIconified(true);
    }
    

    
	/*
	 * public void defaultNav() { home_btn.
	 * setStyle("-fx-background-color: linear-gradient(to bottom right,  #3eac5b, #30bc86)"
	 * ); }
	 */
    //Switching between Forms
    public void switchForms(ActionEvent event) {
    	if(event.getSource() == home_btn) {
    		home_Form.setVisible(true);
    		register_Form.setVisible(false);
    		details_Form.setVisible(false);
    		grade_Form.setVisible(false);
    		home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,  #3eac5b, #30bc86)");
    		register_btn.setStyle("-fx-background-color:transparent");
    		studentsList_btn.setStyle("-fx-background-color:transparent");
    		StudentsGrade_btn.setStyle("-fx-background-color:transparent");
    		homeDisplayTotalaenrolledStudents();
    	    homeDisplayMaleEnrolled();
    	    homeDisplayFemaleEnrolled();
    	    homeDisplayMaleEnrolledChart();
    	    homeDisplayFemaleEnrolledChart();
    	    homeDisplayTotalEnrolledChart ();
    		
    	}else if(event.getSource() == register_btn) {
    		home_Form.setVisible(false);
    		register_Form.setVisible(true);
    		details_Form.setVisible(false);
    		grade_Form.setVisible(false);
    		register_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,  #3eac5b, #30bc86)");
    		home_btn.setStyle("-fx-background-color:transparent");
    		studentsList_btn.setStyle("-fx-background-color:transparent");
    		StudentsGrade_btn.setStyle("-fx-background-color:transparent");
    		//I want to make the data to auto update its self when clicked..
    		addStudentsShowListData();
    		addGender();
    		addLevel();
    		addCourse();
    		addYear();
    		addSem();
    		studentSearch();
    		
    		
    		
    	}else if(event.getSource() == studentsList_btn) {
    		home_Form.setVisible(false);
    		register_Form.setVisible(false);
    		details_Form.setVisible(true);
    		grade_Form.setVisible(false);
    		studentsList_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,  #3eac5b, #30bc86)");
    		home_btn.setStyle("-fx-background-color:transparent");
    		register_btn.setStyle("-fx-background-color:transparent");
    		StudentsGrade_btn.setStyle("-fx-background-color:transparent");
    	     //Auto update the Table when clicked...
    		addToListView();
    		listSearch();
    		
    		
    	}else if(event.getSource() == StudentsGrade_btn) {
    		home_Form.setVisible(false);
    		register_Form.setVisible(false);
    		details_Form.setVisible(false);
    		grade_Form.setVisible(true);
    		StudentsGrade_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,  #3eac5b, #30bc86)");
    		home_btn.setStyle("-fx-background-color:transparent");
    		register_btn.setStyle("-fx-background-color:transparent");
    		studentsList_btn.setStyle("-fx-background-color:transparent");
    		showGradeList();
    		gradeSearch();
    	}
    	
    }
    
    //The logout Method
    public void logout() {
    	try {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Message");
        	alert.setHeaderText(null);
        	alert.setContentText("Are you sure about this?");
        	Optional<ButtonType> option = alert.showAndWait();
        	if(option.get().equals(ButtonType.OK)) {
        		
        		logout_btn.getScene().getWindow().hide();
        		Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        		Stage stage = new Stage();
        		Scene scene = new Scene(root);
        		
        		stage.initStyle(StageStyle.TRANSPARENT);
        		
        		
        		/*Making the alert message Transparent
        		 * while its being dragged both horizontal and vertical
        		 * @ Kato Elvis.....
        		 * EAT: 01:09:46- AM
        		 * Wed/27/2025
        		 * */
        		
        		root.setOnMousePressed((MouseEvent event) ->{
        			x = event.getSceneX();
        			y = event.getSceneY();
        		});
        		
        		root.setOnMouseDragged((MouseEvent event) ->{
        			stage.setX(event.getScreenX() - x);
        			stage.setY(event.getScreenY() - y);
        			
        			stage.setOpacity(.8);
        		});
        		
        		root.setOnMouseReleased((MouseEvent event) ->{
        			stage.setOpacity(1);
        		});
        		
        		stage.setScene(scene);
        		stage.show();
        	}
        	
		
		} catch (Exception e) {e.printStackTrace();}
		
    }
    
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Placed here to load Immediately we add and open up the registration form..
		addStudentsShowListData();
		addGender();
		addToListView();
		addLevel();
		addCourse();
		addYear();
		addSem();
		showGradeList();
		
		homeDisplayTotalaenrolledStudents();
	    homeDisplayMaleEnrolled();
	    homeDisplayFemaleEnrolled();
	    homeDisplayMaleEnrolledChart();
	    homeDisplayFemaleEnrolledChart();
	    homeDisplayTotalEnrolledChart ();

		
	    //The date picker and the contents...
		register_DOB.setValue(LocalDate.now().minusYears(25));
		   register_DOB.setDayCellFactory(picker -> new DateCell() {
		        public void updateItem(LocalDate date, boolean empty) {
		            super.updateItem(date, empty);
		            setDisable(date.isAfter(LocalDate.now())); // Disable future dates
		        }
		    });
	}
}

//The key errors noticed:
/*
 * The date picker isnt fully funtional
 * the gender and email conflict is also problem. either in dataase or UI
 * the total display is fine, but the male and female totals aren fine
 * When a student is deleted, they must also remove the student grades
 * */
