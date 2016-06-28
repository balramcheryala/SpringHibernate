package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.daoimpl.DelhiDareDevilsDaoImpl;
import com.daoimpl.PlayerDaoImpl;
import com.daoimpl.UserDaoImpl;
import com.dto.PlayerDto;
import com.dto.TeamDto;
import com.dto.UserDto;

@Controller("abc")
public class UserController {

	@Autowired
	private UserDaoImpl dao;
	@Autowired
	private PlayerDaoImpl play;
	@Autowired
	private DelhiDareDevilsDaoImpl ddplayer;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}

	/*------Display the user list-----*/
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String show(Model model) {
		System.out.println("in show()");
		model.addAttribute("userdto", new UserDto());
		model.addAttribute("listuser", this.dao.list());
		return "list";
	}

	@RequestMapping("ipl")
	public String demo() {
		System.out.println("demo call");
		return "iplhome";
	}

	/*-----delete function is call-----*/
	@RequestMapping("/deleteemp/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("in delete");
		this.dao.remove(id);

		return "redirect:/list";

	}

	/*-----display the data depending on id------*/
	@RequestMapping("/editemp/{id}")
	public ModelAndView showedit(Model model, @PathVariable("id") int id) {
		UserDto dto = dao.getById(id);
		return new ModelAndView("editemp", "dto", dto);
	}

	/*------update funcation is call-------*/
	@RequestMapping("test")
	public String update(@ModelAttribute("dto") UserDto dto) {
		System.out.println("update controller");
		dao.update(dto);
		return "list";
	}

	/*------display the DDplayer list demo------*/
	@RequestMapping("ddplayerview")
	public String playerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.printList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the Gujrat Lion PlayerList-------*/
	@RequestMapping("glplayerview")
	public String gujratPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.gujratPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the KP  PlayerList-------*/
	@RequestMapping("kpplayerview")
	public String kpPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.punjabPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the KKr  PlayerList-------*/
	@RequestMapping("kkrplayerview")
	public String kkrPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.kkrPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the mumbai indians PlayerList-------*/
	@RequestMapping("mumbaiplayerview")
	public String mumbaiPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.mumbaiPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the rising pune PlayerList-------*/
	@RequestMapping("puneplayerview")
	public String punePlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.risingPunePlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the royal challenges PlayerList-------*/
	@RequestMapping("rcbplayerview")
	public String rcbPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.royalChallengesPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*------ display the sunrise hydrabad PlayerList-------*/
	@RequestMapping("sunriseplayerview")
	public String sunrisesPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new PlayerDto());
		Model result = model.addAttribute("playerlist", this.play.sunriseHydrabadPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
	}
	
	/*--------display the Delhi DareDevils team list-------- */
	@RequestMapping("ddteamview")
	public String DDPlayerList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.teamList());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the Gujrat Lions team list-------- */
	@RequestMapping("glteamview")
	public String gujratTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.gujratTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the punjab team list-------- */
	@RequestMapping("kpteamview")
	public String kpTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.punjabTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	/*--------display the KKR team list--------*/
	@RequestMapping("kkrteamview")
	public String kkrTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.kkrTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the Mumbai indians team list--------*/
	@RequestMapping("mumbaiteamview")
	public String mumbaiTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.mumbaiIndiansTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the Rising pune team list--------*/
	@RequestMapping("puneteamview")
	public String puneTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.risingPuneTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the royal challenges team list--------*/
	@RequestMapping("rcbteamview")
	public String rcbTeamList(Model model) {
		System.out.println("in playlist");
		model.addAttribute("playerdto", new TeamDto());
		Model result = model.addAttribute("ddteam", this.ddplayer.royalChallengesTeam());
		System.out.println();
		System.out.println(result);
		return "ddTeamPlayer";
	}
	
	/*--------display the sunrise hydrabad team list--------*/
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
