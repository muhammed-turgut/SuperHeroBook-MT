package com.muhammedturgut.superheroproject

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.muhammedturgut.superheroproject.ui.theme.SuperHeroProjectTheme

class MainActivity : ComponentActivity() {
    private var superHeroList =ArrayList<SuperHero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController=rememberNavController()

            SuperHeroProjectTheme {
             Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                  NavHost(navController, startDestination = "list_screen")
                  {
                     composable("list_screen"){
                         getData()
                         SuperHeroList(superheros =superHeroList,navController)
                     }
                      composable("details_Screen/{superHero}",
                          arguments = listOf(
                              navArgument("superHero"){
                              type= NavType.StringType
                          }
                          )) {
                          var superHeroString= remember { it.arguments?.getString("superHero") }

                          var selectedSuperHero = Gson().fromJson(superHeroString,SuperHero::class.java)
                          DetailsScreen(superHero = selectedSuperHero)


                      }
                  }
                }
             }
            }
        }

    }
    private fun getData(){
        val Batman=SuperHero(name = "Batman", univerese = "DC", Movis = "Batman Begins (2005),\nThe Dark Knight (2008),\nThe Dark Knight Rises (2012)",
                About = "Batman is one of the most popular superheroes created by DC Comics." +
                "First appearing in Detective Comics 27 in 1939, " +
                "Batman stands out from other superheroes with his dark and mysterious nature." +
                "His real name is Bruce Wayne, a wealthy businessman in Gotham City." +
                "After witnessing his parents' murder as a child, he vows to fight crime and," +
                "after years of intense training, adopts the identity of Batman." +
                "Unlike many other superheroes, Batman has no superpowers. However, " +
                "he relies on his intelligence, martial arts skills," +
                "and advanced technology to become Gotham's greatest crime fighter." +
                "Some of his most famous enemies include Joker, Penguin, Riddler, Two-Face, and Bane.",R.drawable.batman)

        val Superman=SuperHero(name = "Superman", univerese = "DC", Movis ="Man of Steel (2013) – Henry Cavill,\nBatman v Superman: Dawn of Justice (2016) – Henry Cavill,\nJustice League (2017) – Henry Cavill,\nZack Snyder’s Justice League (2021) – Henry Cavill" ,
                 About = "Superman is one of the most iconic superheroes created by DC Comics." +
                "He first appeared in Action Comics 1 in 1938 and is considered the first true superhero." +
                "His real name is Kal-El, and he was born on the planet Krypton. Before Krypton's destruction," +
                "his parents sent him to Earth, where he was adopted by Jonathan and Martha Kent and given the name Clark Kent." +
                "Superman possesses extraordinary abilities, including super strength, flight, heat vision, and near-invulnerability." +
                "He uses his powers to protect humanity, particularly the city of Metropolis. His greatest enemy is Lex Luthor, " +
                "but he also faces threats from villains like General Zod, Brainiac, and Doomsday. Superman is a symbol of hope," +
                "justice, and heroism, making him one of the most beloved characters in comic book history.",R.drawable.superman)

        val Ironman=SuperHero(name = "Iron Man", univerese = "Marvel", Movis ="Iron Man (2008) – Robert Downey Jr. \n,Iron Man 2 (2010) – Robert Downey Jr. ,\nIron Man 3 (2013) – Robert Downey Jr." ,
            About = "Iron Man is one of the most famous superheroes created by Marvel Comics." +
                "He first appeared in Tales of Suspense 39 in 1963. His real name is Tony Stark," +
                "a genius billionaire, playboy, and philanthropist who owns Stark Industries." +
                "After being captured by terrorists and severely injured, he builds the first Iron Man suit to escape." +
                "Realizing the dangers of his own weapons being misused, he decides to become a hero and uses his advanced technology to protect the world.\n" +
                "Unlike many superheroes, Iron Man does not have superpowers. " +
                "Instead, he relies on his high intelligence, engineering skills," +
                "and powerful suits equipped with advanced weapons. His greatest enemies include Mandarin," +
                "Whiplash, and Obadiah Stane. Iron Man is a founding member of the Avengers and plays a crucial role in the Marvel Cinematic Universe (MCU).",R.drawable.ironman)

        val KaptanAmerica=SuperHero(name = "Captain America", univerese = "Marvel", Movis = "Captain America: The First Avenger (2011) – Chris Evans, \nThe Avengers (2012) – Chris Evans, \nCaptain America: The Winter Soldier (2014) – Chris Evans, \nAvengers: Age of Ultron (2015) – Chris Evans, \nCaptain America: Civil War (2016) – Chris Evans",
                 About = "Captain America is one of the most iconic superheroes created by Marvel Comics. " +
                "He first appeared in Captain America Comics 1 in 1941, during World War II." +
                "His real name is Steve Rogers, a frail but determined young man who volunteers " +
                "for a secret government experiment. After receiving the Super Soldier Serum," +
                "he gains enhanced strength, agility, and endurance, becoming America’s greatest warrior." +
                "Captain America is known for his indestructible vibranium shield and his unwavering sense of justice." +
                "He fights against powerful enemies like Red Skull, Hydra, and Baron Zemo. As a leader of the Avengers, " +
                "he represents honor, sacrifice, and patriotism, making him a beloved figure in the Marvel Universe.",R.drawable.kaptanamerica)

        val Antman=SuperHero(name = "Ant-Man", univerese = "Marvel", Movis = "Ant-Man (2015) – Paul Rudd, \nCaptain America: Civil War (2016) – Paul Rudd, \nAnt-Man and the Wasp (2018) – Paul Rudd, \nAvengers: Endgame (2019) – Paul Rudd,\nAnt-Man and the Wasp: Quantumania (2023) – Paul Rudd",
                About = "Ant-Man is one of the most unique superheroes created by Marvel Comics." +
                "He first appeared in Tales to Astonish 27 in 1962, created by Stan Lee, Larry Lieber," +
                "and Jack Kirby. The original Ant-Man, Dr. Hank Pym, is a brilliant scientist" +
                "who invents the Pym Particles, allowing him to shrink to the size of an ant or grow" +
                "to gigantic proportions. However, in the Marvel Cinematic Universe (MCU), Scott Lang," +
                "a former thief with a good heart, becomes the new Ant-Man under Hank Pym’s guidance." +
                "Ant-Man’s abilities include size manipulation, enhanced strength when small," +
                " and communication with ants. His suit allows him to shift sizes rapidly, " +
                "making him a powerful and unpredictable hero. He fights against enemies like " +
                "Yellowjacket and Kang the Conqueror while playing a crucial role in the Avengers, " +
                "especially in Avengers: Endgame, where the Quantum Realm is key to time travel.", R.drawable.antman)

        val Aquaman=SuperHero(name = "Aquaman", univerese = "DC", Movis = "Batman v Superman: Dawn of Justice (2016) – Jason Momoa (Küçük Rol)\n, Justice League (2017) – Jason Momoa,\n Aquaman (2018) – Jason Momoa, \nZack Snyder’s Justice League (2021) – Jason Momoa, \nAquaman and the Lost Kingdom (2023) – Jason Momoa",
                About = "Aquaman is one of the most iconic superheroes created by DC Comics." +
                "He first appeared in More Fun Comics 73 in 1941. His real name is Arthur Curry," +
                "the son of a human lighthouse keeper and Atlanna, the queen of Atlantis." +
                "As the rightful heir to the throne of Atlantis, Aquaman possesses superhuman strength," +
                "the ability to breathe underwater, and telepathic communication with marine life." +
                "Aquaman protects both the surface world and the ocean from threats like " +
                "Ocean Master (his half-brother Orm) and Black Manta. As a member of the Justice League," +
                "he plays a crucial role in maintaining peace between the land and sea. His trident," +
                "made of powerful Atlantean metal, grants him additional abilities," +
                "making him one of the most formidable heroes in the DC Universe.",R.drawable.aquaman)

        val ClintBarton=SuperHero(name = "Clint Barton", univerese = "Marvel", Movis = "Thor (2011) – Jeremy Renner (Küçük Rol), \nThe Avengers (2012) – Jeremy Renner,\n Avengers: Age of Ultron (2015) – Jeremy Renner, \nCaptain America: Civil War (2016) – Jeremy Renner, \nAvengers: Infinity War (2018) – Jeremy Renner (Küçük Rol, Bahsediliyor),\n Avengers: Endgame (2019) – Jeremy Renner",
                About = "Clint Barton, also known as Hawkeye, is one of Marvel Comics' most skilled heroes." +
                "He first appeared in Tales of Suspense 57 in 1964. Unlike many superheroes," +
                "Clint has no superpowers; instead, he is a master archer, marksman, and hand-to-hand combatant." +
                "Trained by the circus and later recruited by S.H.I.E.L.D., he becomes an essential member of the Avengers." +
                "Hawkeye is known for his expert precision, quick reflexes, and ability to adapt in any battle situation." +
                "He has a strong moral compass and deep loyalty to his teammates, especially Black Widow." +
                "His most dangerous foes include Ronin (his own dark alter ego), Taskmaster, and the forces of HYDRA.",R.drawable.clintbarton)

        val Cyborg=SuperHero(name = "Cyborg", univerese = "DC", Movis = "Batman v Superman: Dawn of Justice (2016) – Ray Fisher (Küçük Rol), \nJustice League (2017) – Ray Fisher, \nZack Snyder’s Justice League (2021) – Ray Fisher",
                 About = "Cyborg is one of the most powerful and technologically advanced superheroes in the DC Universe." +
                "He first appeared in DC Comics Presents 26 in 1980. His real name is Victor Stone," +
                "a former high school football star who was gravely injured in a tragic accident." +
                "To save his life, his father, Dr. Silas Stone, used advanced cybernetic " +
                "technology to rebuild Victor’s body, turning him into Cyborg." +
                "Cyborg possesses superhuman strength, advanced hacking abilities, " +
                "and an arsenal of high-tech weapons integrated into his body. " +
                "His most iconic feature is the Mother Box technology, " +
                "which allows him to access vast amounts of information and even manipulate Boom Tubes for teleportation. " +
                "As a key member of the Teen Titans and the Justice League, Cyborg plays a crucial role in " +
                "defending Earth from powerful threats like Darkseid and the forces of Apokolips.",R.drawable.cyborg)

        val Deadpool=SuperHero(name = "Deadpool", univerese = "Marvel", Movis = "X-Men Origins: Wolverine (2009) – Ryan Reynolds,\n Deadpool (2016) – Ryan Reynolds, \nDeadpool 2 (2018) – Ryan Reynolds, \nDeadpool & Wolverine (2024) – Ryan Reynolds & Hugh Jackman",
            About = "Deadpool is one of the most unique and unconventional superheroes in the Marvel Universe." +
                "He first appeared in The New Mutants 98 in 1991, created by Fabian Nicieza and Rob Liefeld." +
                "His real name is Wade Wilson, a former mercenary who, after being diagnosed with terminal cancer," +
                "undergoes an experimental procedure that grants him a superhuman healing factor but also leaves him severely scarred and mentally unstable.\n" +
                "Deadpool is known for his dark humor, fourth-wall-breaking antics, and unmatched combat skills. " +
                "e is an expert in various weapons and hand-to-hand combat. Unlike traditional superheroes," +
                "he often blurs the line between hero and anti-hero, working for his own interests." +
                "His most famous enemies include Ajax, Taskmaster, and Cable (although Cable later becomes his ally).",R.drawable.deadpool)

        val Flash=SuperHero(name = "Flash", univerese = "DC", Movis = "Batman v Superman: Dawn of Justice (2016) – Ezra Miller (Küçük Rol),\n Justice League (2017) – Ezra Miller, \nZack Snyder’s Justice League (2021) – Ezra Miller, \nThe Flash (2023) – Ezra Miller",
                 About = "The Flash is one of the fastest and most iconic superheroes in the DC Universe." +
                "He first appeared in Showcase 4 in 1956, created by Robert Kanigher and Carmine Infantino." +
                "The real identity of The Flash is Barry Allen, a forensic scientist who" +
                "gains super-speed abilities after a freak accident involving chemicals and a lightning strike." +
                "Barry Allen can move at light speed and beyond, which allows him to perform incredible " +
                "feats such as traveling through time, vibrating through walls, and even traveling to alternate universes." +
                "His greatest enemy is Reverse-Flash (Eobard Thawne), who possesses similar speed " +
                "abilities but uses them for evil. The Flash is also a founding member of the Justice " +
                "League and plays a vital role in protecting Central City and the wider multiverse.",R.drawable.flash)

        val GreenLantern=SuperHero(name = "Green Lantern", univerese = "DC", Movis ="Green Lantern (2011) – Ryan Reynolds",
            About = "Green Lantern is one of the most powerful heroes in the DC Universe," +
                "known for wielding the power of the Green Lantern Corps, an intergalactic peacekeeping force." +
                "The Green Lantern ring grants its wearer the ability to create constructs and perform extraordinary feats," +
                "powered by willpower and imagination." +
                "The most famous Green Lantern is Hal Jordan, a fearless test pilot who was chosen " +
                "by the last Green Lantern, Abin Sur, to take his place after his death." +
                "Other key Green Lanterns include John Stewart, Guy Gardner, and Kyle Rayner," +
                "who all carry the mantle at different points in time." +
                "The Green Lantern Corps is tasked with protecting the universe from evil forces," +
                "including their main enemies, the Sinestro Corps and Parallax.",R.drawable.greenlantern)

        val Spiderman=SuperHero(name = "Spider-Man", univerese = "Marvel", Movis ="Spider-Man (2002) – Tobey Maguire, \nSpider-Man 2 (2004) – Tobey Maguire, \nSpider-Man 3 (2007) – Tobey Maguire \nCaptain America: Civil War (2016) – Tom Holland, \nSpider-Man: Homecoming (2017) – Tom Holland, \nAvengers: Infinity War (2018) – Tom Holland, \nAvengers: Endgame (2019) – Tom Holland, \nSpider-Man: Far From Home (2019) – Tom Holland, \nSpider-Man: No Way Home (2021) – Tom Holland" ,
                 About = "Spider-Man is one of the most beloved and iconic superheroes in the Marvel Universe." +
                "He first appeared in Amazing Fantasy 15 in 1962, created by Stan Lee and Steve Ditko. " +
                "His real name is Peter Parker, a high school student living in New York City. " +
                "After being bitten by a radioactive spider, Peter gains the ability to cling to walls, " +
                "enhanced strength, agility, and a \"spider-sense\" that alerts him to danger." +
                "Peter initially uses his powers selfishly, but after the tragic death of his Uncle Ben," +
                "he learns the important lesson that \"with great power comes great responsibility.\" " +
                "As Spider-Man, he balances his life as a student, a photographer, and a superhero, " +
                "fighting villains such as the Green Goblin, Doctor Octopus, and Venom. Spider-Man’s relatability and " +
                "struggles with everyday life have made him one of Marvel's most enduring and popular characters.",R.drawable.spiderman)

        val Thor=SuperHero(name = "Thor", univerese = "Marvel", Movis = "Thor (2011) – Chris Hemsworth, The Avengers (2012) – Chris Hemsworth, \nThor: The Dark World (2013) – Chris Hemsworth, \nAvengers: Age of Ultron (2015) – Chris Hemsworth, \nThor: Ragnarok (2017) – Chris Hemsworth, \nAvengers: Infinity War (2018) – Chris Hemsworth,\n Avengers: Endgame (2019) – Chris Hemsworth, \nThor: Love and Thunder (2022) – Chris Hemsworth",
            About = "Thor is one of the most powerful and well-known superheroes in the Marvel Universe." +
                "He first appeared in Journey into Mystery 83 in 1962, created by Stan Lee," +
                " Larry Lieber, and Jack Kirby. Thor is the Norse God of Thunder, the son of Odin, " +
                "ruler of Asgard, and the goddess Gaea. Thor wields Mjolnir, a magical hammer that grants " +
                "him the ability to control thunder and lightning, fly, and summon powerful energy blasts.\n" +
                "Thor is a warrior of great strength and honor, often caught between his duties to Asgard and his " +
                "desire to protect the Earth. He is a founding member of the Avengers and plays a crucial role in " +
                "protecting the universe from cosmic threats such as Loki, his adopted brother and the God of Mischief, and Thanos." +
                "His character evolves throughout his films, from a proud and impulsive god to a more introspective hero.",R.drawable.thor)

        superHeroList.add(Superman)
        superHeroList.add(Batman)
        superHeroList.add(Ironman)
        superHeroList.add(KaptanAmerica)
        superHeroList.add(Antman)
        superHeroList.add(Aquaman)
        superHeroList.add(ClintBarton)
        superHeroList.add(Cyborg)
        superHeroList.add(Deadpool)
        superHeroList.add(Flash)
        superHeroList.add(GreenLantern)
        superHeroList.add(Spiderman)
        superHeroList.add(Thor)


    }
}
