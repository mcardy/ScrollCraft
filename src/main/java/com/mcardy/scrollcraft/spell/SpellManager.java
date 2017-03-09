package com.mcardy.scrollcraft.spell;

import java.util.ArrayList;
import java.util.List;

public class SpellManager {
	
	private List<Spell> spells;
	
	public SpellManager() {
		spells = new ArrayList<Spell>();
		add(new TestSpell());
		add(new TestSpell2());
	}
	
	public void add(Spell spell) {
		this.spells.add(spell);
	}
	
	public List<Spell> getAllSpells() {
		return spells;
	}
	
	public Spell getSpellById(int id) {
		return spells.get(id);
	}
	
	public int getId(Spell spell) {
		return spells.indexOf(spell);
	}
	
}
