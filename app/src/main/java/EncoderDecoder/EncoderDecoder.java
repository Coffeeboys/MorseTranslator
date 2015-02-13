package EncoderDecoder;

import java.util.*;
public class EncoderDecoder {
	private final MorsePacket dot = new MorsePacket(true, 1);
	private final MorsePacket dash = new MorsePacket(true, 3);
	private final MorsePacket space = new MorsePacket(false, 6);//note: only 6, because adding 1
																//to each letter
	private final MorsePacket spaceBC = new MorsePacket(false, 3);//space between characters
	private final MorsePacket spaceBSC = new MorsePacket(false, 1);//space between same characters
	private HashMap<String, ArrayList<MorsePacket>> alphaTable = makeAlphaTable();
	//conversion table from alpha to MorsePacket
	private HashMap<ArrayList<MorsePacket>, String> morseTable = makeMorseTable();
	//conversion table from MorsePackets to alphabet
	
	//input: string
	//returns an ArrayList of ArrayList of MorsePackets
	public ArrayList<ArrayList<MorsePacket>> encode(String input){
		ArrayList<ArrayList<MorsePacket>> sentence = new ArrayList();
		input = input.toLowerCase();
		for (int k = 0; k<input.length(); k++){
			String s = input.substring(k, k+1);
			if (isAlphaNumeric(s)){
				sentence.add(alphaTable.get(s));
			}
		}
		return sentence;
	}
	
	public String decode(ArrayList<ArrayList<MorsePacket>> input){
		String sentence="";
		for (int k = 0; k<input.size(); k++){
			String s = morseTable.get(input.get(k));
			System.out.println(s);
			sentence=sentence+s;
		}
		
		return sentence;
	}
	
	private boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9 ]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private HashMap<ArrayList<MorsePacket>,String> makeMorseTable(){
		int capacity = 50;
		HashMap<ArrayList<MorsePacket>, String> conversionTable = new HashMap(capacity);
		
		//a
		ArrayList<MorsePacket> a = new ArrayList();
		a.add(dot);
		a.add(spaceBSC);
		a.add(dash);
		a.add(spaceBSC);
		a.add(spaceBC);//space between characters
		conversionTable.put(a, "a");
		
		//b
		ArrayList<MorsePacket> b = new ArrayList();
		b.add(dash);
		b.add(spaceBSC);
		b.add(dot);
		b.add(spaceBSC);
		b.add(dot);
		b.add(spaceBC);
		conversionTable.put(b, "b");
		
		//c
		ArrayList<MorsePacket> c = new ArrayList();
		c.add(dash);
		c.add(spaceBSC);
		c.add(dot);
		c.add(spaceBSC);
		c.add(dash);
		c.add(spaceBSC);
		c.add(dot);
		c.add(spaceBC);
		conversionTable.put(c, "c");
		
		//d
		ArrayList<MorsePacket> d = new ArrayList();
		d.add(dash);
		d.add(spaceBSC);
		d.add(dot);
		d.add(spaceBSC);
		d.add(dot);
		d.add(spaceBC);
		conversionTable.put(d, "d");
		
		//e
		ArrayList<MorsePacket> e = new ArrayList();
		e.add(dot);
		e.add(spaceBC);
		conversionTable.put(e, "e");
		
		//f
		ArrayList<MorsePacket> f = new ArrayList();
		f.add(dot);
		f.add(spaceBSC);
		f.add(dot);
		f.add(spaceBSC);
		f.add(dash);
		f.add(spaceBSC);
		f.add(dot);
		f.add(spaceBC);
		conversionTable.put(f, "f");
		
		//g
		ArrayList<MorsePacket> g = new ArrayList();
		g.add(dash);
		g.add(spaceBSC);
		g.add(dash);
		g.add(spaceBSC);
		g.add(dot);
		g.add(spaceBC);
		conversionTable.put(g, "g");
		
		//h
		ArrayList<MorsePacket> h = new ArrayList();
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBC);
		conversionTable.put(h, "h");
		
		//i
		ArrayList<MorsePacket> i = new ArrayList();
		i.add(dot);
		i.add(spaceBSC);
		i.add(dot);
		i.add(spaceBC);
		conversionTable.put(i, "i");
		
		//j
		ArrayList<MorsePacket> j = new ArrayList();
		j.add(dot);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBC);
		conversionTable.put(j, "j");
		
		//k
		ArrayList<MorsePacket> k = new ArrayList();
		k.add(dash);
		k.add(spaceBSC);
		k.add(dot);
		k.add(spaceBSC);
		k.add(dash);
		k.add(spaceBC);
		conversionTable.put(k, "k");
		
		//l
		ArrayList<MorsePacket> l = new ArrayList();
		l.add(dot);
		l.add(spaceBSC);
		l.add(dash);
		l.add(spaceBSC);
		l.add(dot);
		l.add(spaceBSC);
		l.add(dot);
		l.add(spaceBC);
		conversionTable.put(l, "l");
		
		//m
		ArrayList<MorsePacket> m = new ArrayList();
		m.add(dash);
		m.add(spaceBSC);
		m.add(dash);
		m.add(spaceBC);
		conversionTable.put(m, "m");
		
		//n
		ArrayList<MorsePacket> n = new ArrayList();
		n.add(dash);
		n.add(spaceBSC);
		n.add(dot);
		n.add(spaceBC);
		conversionTable.put(n, "n");
		
		//o
		ArrayList<MorsePacket> o = new ArrayList();
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBC);
		conversionTable.put(o, "o");
		
		//p
		ArrayList<MorsePacket> p = new ArrayList();
		p.add(dot);
		p.add(spaceBSC);
		p.add(dash);
		p.add(spaceBSC);
		p.add(dot);
		p.add(spaceBSC);
		p.add(dash);
		p.add(spaceBC);
		conversionTable.put(p, "p");
		
		//q
		ArrayList<MorsePacket> q = new ArrayList();
		q.add(dash);
		q.add(spaceBSC);
		q.add(dash);
		q.add(spaceBSC);
		q.add(dot);
		q.add(spaceBSC);
		q.add(dash);
		q.add(spaceBC);
		conversionTable.put(q, "q");
		
		//r
		ArrayList<MorsePacket> r = new ArrayList();
		r.add(dot);
		r.add(spaceBSC);
		r.add(dash);
		r.add(spaceBSC);
		r.add(dot);
		r.add(spaceBC);
		conversionTable.put(r, "r");
		
		//s
		ArrayList<MorsePacket> s = new ArrayList();
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBC);//space between characters
		conversionTable.put(s, "s");
		
		//t
		ArrayList<MorsePacket> t = new ArrayList();
		t.add(dash);
		t.add(spaceBC);
		conversionTable.put(t, "t");
		
		//u
		ArrayList<MorsePacket> u = new ArrayList();
		u.add(dot);
		u.add(spaceBSC);
		u.add(dot);
		u.add(spaceBSC);
		u.add(dash);
		u.add(spaceBC);
		conversionTable.put(u, "u");
		
		//v
		ArrayList<MorsePacket> v = new ArrayList();
		v.add(dot);
		v.add(spaceBSC);
		v.add(dot);
		v.add(spaceBSC);
		v.add(dot);
		v.add(spaceBSC);
		v.add(dash);
		v.add(spaceBC);
		conversionTable.put(v, "v");
			
		//w
		ArrayList<MorsePacket> w = new ArrayList();
		w.add(dot);
		w.add(spaceBSC);
		w.add(dash);
		w.add(spaceBSC);
		w.add(dash);
		w.add(spaceBC);
		conversionTable.put(w, "w");
		
		//X
		ArrayList<MorsePacket> x = new ArrayList();
		x.add(dash);
		x.add(spaceBSC);
		x.add(dot);
		x.add(spaceBSC);
		x.add(dot);
		x.add(spaceBSC);
		x.add(dash);
		x.add(spaceBC);
		conversionTable.put(x, "x");
		
		//Y
		ArrayList<MorsePacket> y = new ArrayList();
		y.add(dash);
		y.add(spaceBSC);
		y.add(dot);
		y.add(spaceBSC);
		y.add(dash);
		y.add(spaceBSC);
		y.add(dash);
		y.add(spaceBC);
		conversionTable.put(y, "y");
		
		//Z
		ArrayList<MorsePacket> z = new ArrayList();
		z.add(dash);
		z.add(spaceBSC);
		z.add(dash);
		z.add(spaceBSC);
		z.add(dot);
		z.add(spaceBSC);
		z.add(dot);
		z.add(spaceBC);
		conversionTable.put(z, "z");
		 
		
		//numbers
		//0
		ArrayList<MorsePacket> zero = new ArrayList();
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBC);
		conversionTable.put(zero, "0");
		 
		//1
		ArrayList<MorsePacket> one = new ArrayList();
		one.add(dot);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBC);
		conversionTable.put(one, "1");
		 
		//2
		ArrayList<MorsePacket> two = new ArrayList();
		two.add(dot);
		two.add(spaceBSC);
		two.add(dot);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(spaceBC);
		conversionTable.put(two, "2");
		 
		//3
		ArrayList<MorsePacket> three = new ArrayList();
		three.add(dot);
		three.add(spaceBSC);
		three.add(dot);
		three.add(spaceBSC);
		three.add(dot);
		three.add(spaceBSC);
		three.add(dash);
		three.add(spaceBSC);
		three.add(dash);
		three.add(spaceBC);
		conversionTable.put(three, "3");
		 
		//4
		ArrayList<MorsePacket> four = new ArrayList();
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dash);
		four.add(spaceBC);
		conversionTable.put(four, "4");
		//5
		ArrayList<MorsePacket> five = new ArrayList();
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBC);
		conversionTable.put(five, "5");
		 
		//6
		ArrayList<MorsePacket> six = new ArrayList();
		six.add(dash);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBC);
		conversionTable.put(six, "6");
		 
		//7
		ArrayList<MorsePacket> seven = new ArrayList();
		seven.add(dash);
		seven.add(spaceBSC);
		seven.add(dash);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBC);
		conversionTable.put(seven, "7");
		 
		//8
		ArrayList<MorsePacket> eight = new ArrayList();
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dot);
		eight.add(spaceBSC);
		eight.add(dot);
		eight.add(spaceBC);
		conversionTable.put(eight, "8");
		 
		//9
		ArrayList<MorsePacket> nine = new ArrayList();
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dot);
		nine.add(spaceBC);
		conversionTable.put(nine, "9");
		
		return conversionTable;
		
		
	}
	
	
	
	private HashMap<String, ArrayList<MorsePacket>> makeAlphaTable(){
		int capacity = 50;
		HashMap<String, ArrayList<MorsePacket>> conversionTable = new HashMap(capacity);
		
		//a
		ArrayList<MorsePacket> a = new ArrayList();
		a.add(dot);
		a.add(spaceBSC);
		a.add(dash);
		a.add(spaceBC);//space between characters
		conversionTable.put("a", a);
		
		//b
		ArrayList<MorsePacket> b = new ArrayList();
		b.add(dash);
		b.add(spaceBSC);
		b.add(dot);
		b.add(spaceBSC);
		b.add(dot);
		b.add(spaceBC);
		conversionTable.put("b", b);
		
		//c
		ArrayList<MorsePacket> c = new ArrayList();
		c.add(dash);
		c.add(spaceBSC);
		c.add(dot);
		c.add(spaceBSC);
		c.add(dash);
		c.add(spaceBSC);
		c.add(dot);
		c.add(spaceBC);
		conversionTable.put("c", c);
		
		//d
		ArrayList<MorsePacket> d = new ArrayList();
		d.add(dash);
		d.add(spaceBSC);
		d.add(dot);
		d.add(spaceBSC);
		d.add(dot);
		d.add(spaceBC);
		conversionTable.put("d", d);
		
		//e
		ArrayList<MorsePacket> e = new ArrayList();
		e.add(dot);
		e.add(spaceBC);
		conversionTable.put("e", e);
		
		//f
		ArrayList<MorsePacket> f = new ArrayList();
		f.add(dot);
		f.add(spaceBSC);
		f.add(dot);
		f.add(spaceBSC);
		f.add(dash);
		f.add(spaceBSC);
		f.add(dot);
		f.add(spaceBC);
		conversionTable.put("f", f);
		
		//g
		ArrayList<MorsePacket> g = new ArrayList();
		g.add(dash);
		g.add(spaceBSC);
		g.add(dash);
		g.add(spaceBSC);
		g.add(dot);
		g.add(spaceBC);
		conversionTable.put("g", g);
		
		//h
		ArrayList<MorsePacket> h = new ArrayList();
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBSC);
		h.add(dot);
		h.add(spaceBC);
		conversionTable.put("h", h);
		
		//i
		ArrayList<MorsePacket> i = new ArrayList();
		i.add(dot);
		i.add(spaceBSC);
		i.add(dot);
		i.add(spaceBC);
		conversionTable.put("i", i);
		
		//j
		ArrayList<MorsePacket> j = new ArrayList();
		j.add(dot);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBSC);
		j.add(dash);
		j.add(spaceBC);
		conversionTable.put("j", j);
		
		//k
		ArrayList<MorsePacket> k = new ArrayList();
		k.add(dash);
		k.add(spaceBSC);
		k.add(dot);
		k.add(spaceBSC);
		k.add(dash);
		k.add(spaceBC);
		conversionTable.put("k", k);
		
		//l
		ArrayList<MorsePacket> l = new ArrayList();
		l.add(dot);
		l.add(spaceBSC);
		l.add(dash);
		l.add(spaceBSC);
		l.add(dot);
		l.add(spaceBSC);
		l.add(dot);
		l.add(spaceBC);
		conversionTable.put("l", l);
		
		//m
		ArrayList<MorsePacket> m = new ArrayList();
		m.add(dash);
		m.add(spaceBSC);
		m.add(dash);
		m.add(spaceBC);
		conversionTable.put("m", m);
		
		//n
		ArrayList<MorsePacket> n = new ArrayList();
		n.add(dash);
		n.add(spaceBSC);
		n.add(dot);
		n.add(spaceBC);
		conversionTable.put("n", n);
		
		//o
		ArrayList<MorsePacket> o = new ArrayList();
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBC);
		conversionTable.put("o", o);
		
		//p
		ArrayList<MorsePacket> p = new ArrayList();
		p.add(dot);
		p.add(spaceBSC);
		p.add(dash);
		p.add(spaceBSC);
		p.add(dot);
		p.add(spaceBSC);
		p.add(dash);
		p.add(spaceBC);
		conversionTable.put("p", p);
		
		//q
		ArrayList<MorsePacket> q = new ArrayList();
		q.add(dash);
		q.add(spaceBSC);
		q.add(dash);
		q.add(spaceBSC);
		q.add(dot);
		q.add(spaceBSC);
		q.add(dash);
		q.add(spaceBC);
		conversionTable.put("q", q);
		
		//r
		ArrayList<MorsePacket> r = new ArrayList();
		r.add(dot);
		r.add(spaceBSC);
		r.add(dash);
		r.add(spaceBSC);
		r.add(dot);
		r.add(spaceBC);
		conversionTable.put("r", r);
		
		//s
		ArrayList<MorsePacket> s = new ArrayList();
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBC);//space between characters
		conversionTable.put("s", s);
		
		//t
		ArrayList<MorsePacket> t = new ArrayList();
		t.add(dash);
		t.add(spaceBC);
		conversionTable.put("t", t);
		
		//u
		ArrayList<MorsePacket> u = new ArrayList();
		u.add(dot);
		u.add(spaceBSC);
		u.add(dot);
		u.add(spaceBSC);
		u.add(dash);
		u.add(spaceBC);
		conversionTable.put("u", u);
		
		//v
		ArrayList<MorsePacket> v = new ArrayList();
		v.add(dot);
		v.add(spaceBSC);
		v.add(dot);
		v.add(spaceBSC);
		v.add(dot);
		v.add(spaceBSC);
		v.add(dash);
		v.add(spaceBC);
		conversionTable.put("v", v);
			
		//w
		ArrayList<MorsePacket> w = new ArrayList();
		w.add(dot);
		w.add(spaceBSC);
		w.add(dash);
		w.add(spaceBSC);
		w.add(dash);
		w.add(spaceBC);
		conversionTable.put("w", w);
		
		//X
		ArrayList<MorsePacket> x = new ArrayList();
		x.add(dash);
		x.add(spaceBSC);
		x.add(dot);
		x.add(spaceBSC);
		x.add(dot);
		x.add(spaceBSC);
		x.add(dash);
		x.add(spaceBC);
		conversionTable.put("x",x);
		
		//Y
		ArrayList<MorsePacket> y = new ArrayList();
		y.add(dash);
		y.add(spaceBSC);
		y.add(dot);
		y.add(spaceBSC);
		y.add(dash);
		y.add(spaceBSC);
		y.add(dash);
		y.add(spaceBC);
		conversionTable.put("y", y);
		
		//Z
		ArrayList<MorsePacket> z = new ArrayList();
		z.add(dash);
		z.add(spaceBSC);
		z.add(dash);
		z.add(spaceBSC);
		z.add(dot);
		z.add(spaceBSC);
		z.add(dot);
		z.add(spaceBC);
		conversionTable.put("z", z);
		 
		
		//numbers
		//0
		ArrayList<MorsePacket> zero = new ArrayList();
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBSC);
		zero.add(dash);
		zero.add(spaceBC);
		conversionTable.put("0",zero);
		 
		//1
		ArrayList<MorsePacket> one = new ArrayList();
		one.add(dot);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBSC);
		one.add(dash);
		one.add(spaceBC);
		conversionTable.put("1",one);
		 
		//2
		ArrayList<MorsePacket> two = new ArrayList();
		two.add(dot);
		two.add(spaceBSC);
		two.add(dot);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(dash);
		two.add(spaceBSC);
		two.add(spaceBC);
		conversionTable.put("2",two);
		 
		//3
		ArrayList<MorsePacket> three = new ArrayList();
		three.add(dot);
		three.add(spaceBSC);
		three.add(dot);
		three.add(spaceBSC);
		three.add(dot);
		three.add(spaceBSC);
		three.add(dash);
		three.add(spaceBSC);
		three.add(dash);
		three.add(spaceBC);
		conversionTable.put("3", three);
		 
		//4
		ArrayList<MorsePacket> four = new ArrayList();
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dot);
		four.add(spaceBSC);
		four.add(dash);
		four.add(spaceBC);
		conversionTable.put("4", four);
		//5
		ArrayList<MorsePacket> five = new ArrayList();
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBSC);
		five.add(dot);
		five.add(spaceBC);
		conversionTable.put("5", five);
		 
		//6
		ArrayList<MorsePacket> six = new ArrayList();
		six.add(dash);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBSC);
		six.add(dot);
		six.add(spaceBC);
		conversionTable.put("6",six);
		 
		//7
		ArrayList<MorsePacket> seven = new ArrayList();
		seven.add(dash);
		seven.add(spaceBSC);
		seven.add(dash);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBSC);
		seven.add(dot);
		seven.add(spaceBC);
		conversionTable.put("7", seven);
		 
		//8
		ArrayList<MorsePacket> eight = new ArrayList();
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dash);
		eight.add(spaceBSC);
		eight.add(dot);
		eight.add(spaceBSC);
		eight.add(dot);
		eight.add(spaceBC);
		conversionTable.put("8", eight);
		 
		//9
		ArrayList<MorsePacket> nine = new ArrayList();
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dash);
		nine.add(spaceBSC);
		nine.add(dot);
		nine.add(spaceBC);
		conversionTable.put("9",nine);
		
		//space
		ArrayList<MorsePacket> spaceX = new ArrayList();
		spaceX.add(space);
		conversionTable.put(" ", spaceX);
		
		return conversionTable;
	}
	
}





