package com.bridgelabz.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.dao.DelhiDareDevilsDaoImpl;
import com.bridgelabz.dao.PlayerDaoImpl;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
import com.fasterxml.jackson.databind.ObjectMapper;


// Controller
@Controller("abc")
public class JsonController {


	//@Autowired annotation can be used to autowire bean on the setter method 
	@Autowired
	private DelhiDareDevilsDaoImpl ddplayer;
	
	@Autowired
	private PlayerDaoImpl play;
	
	@Autowired
	public SessionFactory sessionfactory;
	
	//@RequestMapping with Method: We can use it with method to provide the URI pattern.
	//for which handler method will be used
	//@RequestMapping can be applied to the controller class as well as methods
	@RequestMapping(value="/ipl.html",method = RequestMethod.GET)
	public String showForm(Map<?, ?> model)
	{
		return "iplhome";
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
	
	// Searching 
	//The GET method is used to retrieve information from the given server using a given URI
	@RequestMapping(value="/search", method = RequestMethod.GET)
	//@RequestParam annotation to retrieve the URL parameter and map it to the method argument
	public ModelAndView searchbyname(@RequestParam(value="by", required=true) String by,@RequestParam(value="q", required=true) String query) 
	{
		//Map contains only unique keys.
		//Map is useful if you have to search, update or delete elements on the basis of key.
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(by);
		System.out.println(query);
		model.put("playerlist", play.jsonsearch(by,query));
		return new ModelAndView("playerlist",model);
		
	}
	
	// sorting
	@RequestMapping(value="/sort", method = RequestMethod.GET)
	public ModelAndView sort(@RequestParam(value="sortby", required=true) String fieldName) 
	{
		//This implementation provides all of the optional map operations.
		//And permits null values and the null key.
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("playerlist", play.jsonsorting( fieldName));
			return new ModelAndView("playerlist",model);
			
		}

	//Fallback for all requests using a specific HTTP method 
	@RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView error(Map<?, ?> model)
	{
		return new ModelAndView("error");
	}
	
	
	//Delhi DareDevils team list 
	@RequestMapping("ddteamview")
	//The Model encapsulates the application data and in general they will consist of POJO
	public String DDPlayerList(Model model) {
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", ddplayer.teamList());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	// json view 
	@RequestMapping(value="ddplayerdetail", method = RequestMethod.GET,produces="application/json")
	public String DDTeamList() throws IOException
	{
		ArrayList output=new ArrayList();
		   output= play.printList();
		   ObjectMapper mapper = new ObjectMapper();
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output);
	}
	
	//display DDplayer list demo------
	@RequestMapping("ddplayerview")
	public String playerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist",play.printList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display Gujrat Lion PlayerList-------
	@RequestMapping("glplayerview")
	public String gujratPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.gujratPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display KP  PlayerList-------
	@RequestMapping("kpplayerview")
	public String kpPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.punjabPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display KKr  PlayerList-------
	@RequestMapping("kkrplayerview")
	public String kkrPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.kkrPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display mumbai indians PlayerList-------
	@RequestMapping("mumbaiplayerview")
	public String mumbaiPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.mumbaiPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display rising pune PlayerList-------
	@RequestMapping("puneplayerview")
	public String punePlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.risingPunePlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display royal challenges PlayerList-------
	@RequestMapping("rcbplayerview")
	public String rcbPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.royalChallengesPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	// display sunrise hydrabad PlayerList-------
	@RequestMapping("sunriseplayerview")
	public String sunrisesPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.sunriseHydrabadPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	//Gujrat Lions team list 
	@RequestMapping("glteamview")
	public String gujratTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.gujratTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	//punjab team list 
	@RequestMapping("kpteamview")
	public String kpTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.punjabTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	//KKR team list
	@RequestMapping("kkrteamview")
	public String kkrTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.kkrTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	//Mumbai indians team list
	@RequestMapping("mumbaiteamview")
	public String mumbaiTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.mumbaiIndiansTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	//Rising pune team list
	@RequestMapping("puneteamview")
	public String puneTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.risingPuneTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	//royal challenges team list
	@RequestMapping("rcbteamview")
	public String rcbTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.royalChallengesTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	//sunrise hydrabad team list
	@RequestMapping("sunriseteamview")
	public String sunriseTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.sunriseHydrabadTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
}
