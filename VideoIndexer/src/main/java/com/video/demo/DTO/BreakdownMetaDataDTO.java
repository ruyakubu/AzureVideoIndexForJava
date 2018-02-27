package com.video.demo.DTO;

import java.util.List;
import java.util.ArrayList;

import com.video.demo.domain.Faces;

public class BreakdownMetaDataDTO {
	
	private String breakdown;
	private List<Faces> faces = new ArrayList<Faces>();
	
	public String getBreakdown() {
		return breakdown;
	}
	public void setBreakdown(String breakdownId) {
		this.breakdown = breakdownId;
	}
	public List<Faces> getFaces() {
		return faces;
	}
	public void setFaces(List<Faces> faces) {
		this.faces = faces;
	}
	

}
