package com.cs401.alpha.crossAI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.cs401.alpha.crossAI.User;
import com.cs401.alpha.crossAI.UserRepository;

@Controller
public class AppController {

	@Autowired
	private ExcerciseRepository excerciseRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@RequestMapping(value = "/GetUserAvailibility")
	public void GetUserAvailibility(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("userId").trim();
		System.out.println("inside GetUserAvailibility");
		System.out.println(uid);

		Optional<User> ou = userRepository.findById(uid);

		System.out.println(ou.isPresent());
		String GetUserAvailibility = null;

		if (uid.isEmpty()) {
			GetUserAvailibility = "please enter userid";
		}

		else if (ou.isPresent()) {

			GetUserAvailibility = "user not available";
		} else {
			GetUserAvailibility = "user available";
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		out.print(GetUserAvailibility);
		out.flush();

	}

	@RequestMapping("/test")
	@GetMapping("/test")
	public String test() {
		System.out.println("Welcome test");
		return "test";
	}

	@RequestMapping("/login")
	@GetMapping("/login")
	public String Login() {
		System.out.println("Welcome Login");
		return "login";
	}

	@PostMapping("/checklogin")
	public ModelAndView checklogin(User user, Model model) {
		model.addAttribute("user", user);

		String userId = user.getUserId();
		String password = user.getPassword();
		System.out.println(userId);
		ModelAndView mv = new ModelAndView();
		CheckUserRole cur = new CheckUserRole();

		String usertype = "";

		try {
			usertype = cur.CheckUser(userId, password);

		} catch (SQLException e) {

			System.out.println("in exception");
			e.printStackTrace();
		}

		System.out.println("usertype=" + usertype);
		String InvalidUserOrPassword = null;
		if (usertype.equalsIgnoreCase("yesAdmin")) {
			mv.setViewName("adminHome");
			return mv;
		} else if (usertype.equalsIgnoreCase("NoAdmin")) {
			mv.addObject("userId", userId);
			mv.setViewName("nonAdminHome");
			return mv;
		} else {
			mv.setViewName("login");
			InvalidUserOrPassword = "User or password does not exists";
			mv.addObject("InvalidUserOrPassword", InvalidUserOrPassword.toString());
			return mv;
		}
	}

	@RequestMapping("home")
	public ModelAndView home(@RequestParam(value = "name", required = false) String myName,
			@RequestParam(value = "age", required = false) Integer myAge) {

		ModelAndView mv = new ModelAndView();
		if (myName.equals(null) || myName.equals("")) {
			myName = "Tester";
		}
		mv.addObject("name", myName);
		if (myAge < 0) {
			System.out.println("Age can't be a -ve value so seteting it to 0");
			myAge = 0;
		} else if (myAge > 0) {
			myAge = myAge;

		} else {
			myAge = -1;
		}

		mv.addObject("age", myAge);
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("/addExercise")
	public String addanExercise() {
		return "addExerciseView";
	}

	@RequestMapping("/addexercise")
	@ResponseBody
	public ModelAndView addexercise(String exercise, String exercisedesc) {

		ModelAndView mv = new ModelAndView();
		System.out.println("inside addexercise from form view");
		String uid = "";
		Exercise exe = new Exercise(exercise, exercisedesc);
		System.out.println(exe.getExcercise());
		System.out.println(exe.getExcercisedesc());

		excerciseRepository.save(exe);

		uid = String.valueOf(exe.getIdexcercise());

		mv.addObject("uid", uid);
		mv.setViewName("exerciseAddedSucess");
		return mv;
	}

	// adminhome -> start chekcin-> stop checkin

	@RequestMapping("/startCheckIn")
	public String startCheckIn(Model model) {

		ArrayList<String> allsuers = new ArrayList<String>();

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT userId FROM alphadb.user ";

		System.out.println(query); // create the java statement
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String tempid = null;
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					tempid = rs.getString(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				allsuers.add(tempid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("allusers", allsuers);

		return "startCheckIn";

	}

	@RequestMapping("/stopCheckIn") // this should generate the json file with user ids, exercises and other
									// details. calls generatejson
	public String stopCheckIn(@RequestParam(value = "userIds", required = false) String[] userIds, Model model,
			String date, String time, String nameofclass) throws FileNotFoundException, SQLException {

		System.out.println(userIds.length);
		for (int i = 0; i < userIds.length; i++) {
			System.out.println("userids " + userIds[i]);
		}

		System.out.println("inside stop chekin");

		JSONObject joo = new JSONObject();
		joo = generateJson(userIds, date, time, nameofclass);

		System.out.println(joo);

		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(joo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// the json that is created needs to loaded in database. this call is for that
		// purpose
		String dbStoredStatus = storeJsoninDatbase(joo, userIds, jsonString);

		model.addAttribute("jsonexer", jsonString);
		return "stopCheckIn";

	}

	// @RequestMapping("/storeJsoninDatbase") // class complete, store json in
	// database
	public String storeJsoninDatbase(JSONObject joo, String[] uids, String jsonString) {
		// have to store json file in databse
		// have to extract user names and exericse dates, etx and store in db.

		System.out.println("inside storeJsoninDatbase");

		System.out.println(joo.get("id"));
		System.out.println(joo.get("userids"));
		System.out.println(joo.get("date"));
		System.out.println(joo.get("time"));
		System.out.println(joo.get("name"));

		System.out.println(joo.get("exercisetypes"));

		// calling to store in database with above values;

		UserHistoRel uhr = new UserHistoRel();
		uhr.saveInHistoAndRelTable(joo, uids, jsonString);

		System.out.println("came out of Saving");

		return "success";
	}

	@RequestMapping("/generateJson") // checkin complete, generate json
	public JSONObject generateJson(String[] userIds, String date, String time, String nameofclass)
			throws FileNotFoundException, SQLException {
		System.out.println("inside generateJson");

		Exercise exercise1 = new Exercise("pushup", "chest");
		Exercise exercise2 = new Exercise("pullup", "back");
		Exercise exercise3 = new Exercise("jumping jack", "cardio");

		ArrayList<Exercise> arraylist1 = new ArrayList<Exercise>();

		arraylist1.add(exercise1);
		arraylist1.add(exercise2);

		ArrayList<Exercise> arraylist2 = new ArrayList<Exercise>();
		arraylist2.add(exercise1);
		arraylist2.add(exercise2);
		arraylist2.add(exercise3);

		ArrayList<Exercise> arraylist3 = new ArrayList<Exercise>();
		arraylist3.add(exercise3);

		Types type1 = new Types(5, arraylist1);
		Types type2 = new Types(5, arraylist2);
		Types type3 = new Types(5, arraylist3);

		ExerciseTypes exerciseTypes1 = new ExerciseTypes("warmup", type1);
		ExerciseTypes exerciseTypes2 = new ExerciseTypes("Tabata", type2);
		ExerciseTypes exerciseTypes3 = new ExerciseTypes("cooldown", type3);

		ArrayList<ExerciseTypes> ET = new ArrayList<ExerciseTypes>();
		ET.add(exerciseTypes1);
		ET.add(exerciseTypes2);
		ET.add(exerciseTypes3);

		ArrayList<String> uids = new ArrayList<String>();

		System.out.println(userIds.length);
		for (int i = 0; i < userIds.length; i++) {
			System.out.println("userids " + userIds[i]);
			uids.add(userIds[i]);
		}

		// get the latest id from hist table.
		LatestIdFromHisto lifh = new LatestIdFromHisto();
		int latestId4mHisto = lifh.getid();

		System.out.println("latestId4mHisto : " + latestId4mHisto);

		ExerciseSession exerciseSession = new ExerciseSession(latestId4mHisto, date, time, nameofclass, uids, ET);

		System.out.println(exerciseSession.getExercisetypes().size());

		JSONObject jo = new JSONObject();
		jo.put("id", exerciseSession.getId());
		jo.put("date", exerciseSession.getDate());
		jo.put("time", exerciseSession.getTime());
		jo.put("name", exerciseSession.getName());
		jo.put("userids", exerciseSession.getUserids());

		JSONArray joexternal = new JSONArray();

		for (ExerciseTypes et : exerciseSession.getExercisetypes()) {

			JSONObject jointernal = new JSONObject();

			System.out.println(et.getName() + et.getTypes());

			jointernal.put("name", et.getName());
			jointernal.put("duration", et.getTypes().getDuration());

			ArrayList<String> exercs = new ArrayList<String>();

			for (Exercise e : et.getTypes().getExercises()) {

				JSONObject jointernalinternal = new JSONObject();
				exercs.add(e.getExcercise());
			}

			jointernal.put("excercises", exercs);
			joexternal.add(jointernal);

		}
		jo.put("exercisetypes", joexternal);

		PrintWriter pw = new PrintWriter("ExerciseClass.json");
		pw.write(jo.toJSONString());

		pw.flush();
		pw.close();

		return jo;
		// return "generatedJsonFile";
	}

	/**
	 * 
	 * Web end point Aboutus for About us data
	 * 
	 * @return aboutus.jsp page
	 */
	@RequestMapping("/Aboutus")
	public String aboutus(Model model) {
		System.out.println("Welcome about us");
		AboutusBusinesslogic business = new AboutusBusinesslogic();
		List<Aboutus> listus = business.getAboutusList();
		model.addAttribute("aboutus", listus);
		return "aboutus";
	}

	/**
	 * 
	 * Rest end point AboutusRest for a GET call to get About us data
	 * 
	 * @return A list containing About us data
	 */

	@GetMapping("/AboutusRest")
	@ResponseBody
	public List<Aboutus> aboutusrest() {
		System.out.println(" Rest Get call about us");
		AboutusBusinesslogic business = new AboutusBusinesslogic();
		List<Aboutus> listus = business.getAboutusList();
		return listus;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping(path = "/newuserrest")
	public ResponseEntity<Object> createUserrest(@Valid @RequestBody User user) {

		System.out.println("inside new user creation");
		User u = userRepository.save(user);

		System.out.println("new user creaetd");
		String createdUid = u.getUserId();
		System.out.println(createdUid);

		Optional<User> us = getUserAfterCreate(createdUid);
		System.out.println(us);
		System.out.println(us.get().getFirstName());

		return new ResponseEntity<>(us, HttpStatus.CREATED);
	}

	/**
	 * This end point is called from login page
	 * 
	 * @return registration page
	 */
	@GetMapping(path = "/registration") // calls registration form that has form action newuser
	public String registerUser() {
		return "registration";
	}

	/**
	 * This end point is called from registration
	 * 
	 * @return userAddedSucess page
	 */
	@PostMapping(path = "/newuser") // is called from registration
	public @ResponseBody ModelAndView createUser(@Valid User user) {

		ModelAndView mv = new ModelAndView();

		User u = userRepository.save(user);

		String createdUid = u.getUserId();
		System.out.println(createdUid);

		Optional<User> us = getUserAfterCreate(createdUid);
		System.out.println(us);
		System.out.println(us.get().getFirstName());

		mv.addObject("userid", us.get().getUserId());
		mv.addObject("upassword", us.get().getPassword());
		mv.addObject("firstName", us.get().getFirstName());
		mv.addObject("lastName", us.get().getLastName());
		mv.addObject("email", us.get().getEmail());
		mv.addObject("phone", us.get().getPhone());
		mv.addObject("gender", us.get().getGender());
		mv.addObject("age", us.get().getAge());
		mv.addObject("height", us.get().getHeight());

		mv.setViewName("userAddedSucess");
		return mv;
	}

	@PostMapping(path = "/saveRoleUser")
	public ModelAndView saveRoleUser(String userRoleid, String status) {
		ModelAndView mv = new ModelAndView();
		System.out.println("userRoleid : " + userRoleid);
		System.out.println("status : " + status);

		String temprole = null;
		if (status.equalsIgnoreCase("Admin")) {
			temprole = "1";
		} else {
			temprole = "2";
		}

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String userrolerelquery = "update alphadb.user_role_rel set roleId =" + temprole + " where userId =" + "\""
				+ userRoleid + "\"";

		System.out.println(userrolerelquery);
		Statement st = null;

		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			st.execute(userrolerelquery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		mv.setViewName("RoleChangedSuccessfully");
		return mv;

	}

	@PostMapping(path = "/saveEditedUser") // is called from edit user
	public @ResponseBody ModelAndView saveEditedUser(@Valid @ModelAttribute User user, String userid) {

		ModelAndView mv = new ModelAndView();
		System.out.println("inside edit and save");

		user.setUserId(userid);
		System.out.println(user.getBmi());

		User u = userRepository.save(user);

		String createdUid = u.getUserId();
		System.out.println(createdUid);

		Optional<User> us = getUserAfterCreate(createdUid);
		System.out.println(us);
		System.out.println(us.get().getFirstName());

		mv.addObject("userid", us.get().getUserId());
		mv.addObject("upassword", us.get().getPassword());
		mv.addObject("firstName", us.get().getFirstName());
		mv.addObject("lastName", us.get().getLastName());
		mv.addObject("email", us.get().getEmail());
		mv.addObject("phone", us.get().getPhone());
		mv.addObject("gender", us.get().getGender());
		mv.addObject("age", us.get().getAge());
		mv.addObject("height", us.get().getHeight());

		mv.setViewName("userEditedSucess");
		return mv;
	}

	@GetMapping(path = "/adminhome")
	public String adminhome(String uid) {
		System.out.println("inside admin home");
		return "adminHome";
	}

	@GetMapping(path = "/nonadminhome")
	public String nonadminhome(String uid) {
		System.out.println("inside non admin home");
		return "nonadminHome";
	}

//	@GetMapping
	public @ResponseBody Optional<User> getUserAfterCreate(String uid) {
		System.out.println("inside getUserAfterCreate");
		return userRepository.findById(uid);
	}

	@RequestMapping("/getUserDetails")
	public ModelAndView getUserDetails(@RequestParam String uid) throws SQLException {
		ModelAndView mv = new ModelAndView();

		System.out.println(uid);
		Optional<User> us = userRepository.findById(uid);

		System.out.println("showing user");
		System.out.println(us.toString());

		mv.addObject("userid", us.get().getUserId());
		mv.addObject("upassword", us.get().getPassword());
		mv.addObject("firstName", us.get().getFirstName());
		mv.addObject("lastName", us.get().getLastName());
		mv.addObject("email", us.get().getEmail());
		mv.addObject("phone", us.get().getPhone());
		mv.addObject("gender", us.get().getGender());
		mv.addObject("age", us.get().getAge());
		mv.addObject("height", us.get().getHeight());

		UserHistoRel uhr = new UserHistoRel();
		List<Histo> hist = uhr.query4mRel4Userid(uid);
		System.out.println(hist);

		mv.addObject("history", hist);
		mv.setViewName("showUserDetails");
		return mv;
	}

	@GetMapping(path = "/edituserdetails")
	public ModelAndView edituserdetails(@RequestParam String userd) throws SQLException {
		ModelAndView mv = new ModelAndView();

		System.out.println(userd);
		Optional<User> u = userRepository.findById(userd);

		if (!u.isPresent()) {
			mv.setViewName("EditUserDetailsUserNotPresent");
			return mv;
		}

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/alphadb";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String rolequery = "SELECT * FROM alphadb.user_role_rel where userId =" + "\"" + userd + "\"";

		System.out.println(rolequery);
		Statement st = null;

		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;

		try {
			rs = st.executeQuery(rolequery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String tempRole = null;
		if (rs.next()) {
			System.out.println("role is ");
			System.out.println(rs.getString(2));
			tempRole = rs.getString(2);
		}

		String currRole = null;

		if (tempRole.equalsIgnoreCase("1")) {
			currRole = "Admin";
		} else {
			currRole = "NonAdmin";
		}

		mv.addObject("currRole", currRole);
		mv.addObject("userIdRoleRel", rs.getString(1));

		System.out.println(u.toString());

		mv.addObject("userid", u.get().getUserId());
		mv.addObject("password", u.get().getPassword());
		mv.addObject("firstName", u.get().getFirstName());
		mv.addObject("lastName", u.get().getLastName());
		mv.addObject("email", u.get().getEmail());
		mv.addObject("phone", u.get().getPhone());
		mv.addObject("gender", u.get().getGender());
		mv.addObject("age", u.get().getAge());
		mv.addObject("height", u.get().getHeight());

		mv.addObject("fat", u.get().getFat());
		mv.addObject("bmi", u.get().getBmi());
		mv.addObject("fitScore", u.get().getFitscore());
		mv.addObject("goal", u.get().getGoal());
		mv.addObject("weight", u.get().getWeight());
		mv.addObject("status", u.get().getStatus());

		mv.setViewName("EditUserDetails");
		return mv;
	}

	@GetMapping(path = "/allexcercises")
	public @ResponseBody Iterable<Exercise> getAllExercise() {
		return excerciseRepository.findAll();
	}

	@GetMapping(path = "/getfeedback")
	public String getfeedback() {
		return "userfeedback";
	}

	/**
	 * check here if the user id entered is present in database. If not then
	 * register the feedback with userid as Anonymous if feedback is empty then
	 * store feedback as default entry "Feedback was empty, or no feedback was
	 * provided"
	 * 
	 * @author ppanda
	 * @param String userid
	 * @param String feedback
	 * @param String datetime
	 * @param String score
	 * @return String i.e. name of jsp file
	 * 
	 */

	@PostMapping(path = "/addfeedback")
	public String addfeedback(String userid, String feedbac, String datetime, String score) {

		System.out.println(feedbac);

		if (userid.equalsIgnoreCase(null) || userid.isEmpty()) {
			userid = "Anonymous";
		}

		Optional<User> ou = userRepository.findById(userid);

		if (!ou.isPresent()) {
			userid = "Anonymous";
		}

		if (feedbac.equalsIgnoreCase(null) || feedbac.isEmpty()) {
			feedbac = "Feedback was empty, or no feedback was provided";
		}

		if (datetime.equalsIgnoreCase(null) || datetime.isEmpty()) {
			Date date = new Date();
			datetime = date.toString();
		}

		try {
			if (score.equalsIgnoreCase(null) || score.isEmpty()) {
				score = "0";
			}

			if (Integer.parseInt(score) < 0) {
				score = "0";
			}

			if (Integer.parseInt(score) >= 10) {
				score = "10";
			}
		} catch (java.lang.NumberFormatException e) {
			System.out.println("There is a number format exception for score hence storing 0");
			score = "0";
		}

		Feedback f = new Feedback(userid, datetime, feedbac, score);
		feedbackRepository.save(f);
		return "feedbacksavedsuccessgully";
	}

	@GetMapping(path = "/analyzefeedback")
	public String analyzefeedback() {

		return "showfeedback";
	}

}
