package fptai.chatbot.sdk.models;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarouselContent {
	
	@JsonProperty("carousel_cards")
	private ArrayList<CarouselCard> carouselCards;

	public ArrayList<CarouselCard> getCarouselCards() {
		return carouselCards;
	}

	public void setCarouselCards(ArrayList<CarouselCard> carouselCards) {
		this.carouselCards = carouselCards;
	}
	
}
