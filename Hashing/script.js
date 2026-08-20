const INSTAGRAM_URL =
  "https://www.instagram.com/the_shiva.03/";

const NOTES_URL =
  "https://nebula-keyboard-8f9.notion.site/All-Links-3ac4b1b3970480d8baadf1218756e448";

const DAYS = {
  1: {
    title: "Think Before You Code",
    level: "FOUNDATION",
    description:
      "Learn how to break a simple problem into smaller logical decisions.",

    // Add a YouTube URL here later
    video: "",

    problems: [
      [
        "The Bigger Number",
        "Given two numbers, determine which is larger.",
        "easy",
        "Compare the two values before deciding what to print."
      ],

      [
        "Even or Odd",
        "Determine whether a number is even or odd.",
        "easy",
        "Think about what property separates even and odd numbers."
      ],

      [
        "Three Number Challenge",
        "Given three different numbers, determine which one is the largest.",
        "medium",
        "Compare values step by step instead of guessing."
      ],

      [
        "The Hidden Condition",
        "A number is special if it is positive and even. Determine whether it is special.",
        "medium",
        "Break the sentence into two independent conditions."
      ],

      [
        "The Decision Problem",
        "Given three numbers, determine whether they form a strictly increasing sequence.",
        "hard",
        "The first must be smaller than the second, and the second smaller than the third."
      ]
    ]
  },

  2: {
    title: "Mastering Conditions",
    level: "FOUNDATION",
    description:
      "Combine multiple conditions and learn how decisions work together.",

    // Add a YouTube URL here later
    video: "",

    problems: [
      [
        "Positive, Negative or Zero",
        "Determine whether a number is positive, negative, or exactly zero.",
        "easy",
        "There are three possible states. Check the equality case explicitly."
      ],

      [
        "Voting Eligibility",
        "Given an age, determine whether the person is eligible to vote.",
        "easy",
        "Start by identifying the threshold condition."
      ],

      [
        "Largest of Three",
        "Find the largest of three numbers using logical comparisons.",
        "medium",
        "A good approach reduces the problem to repeated comparisons."
      ],

      [
        "Leap Year Logic",
        "Determine whether a year is a leap year using the special century rule.",
        "medium",
        "The rule has a primary condition and an exception."
      ],

      [
        "Triangle Validator",
        "Given three side lengths, determine whether they can form a valid triangle.",
        "hard",
        "Use the relationship between the sum of any two sides and the remaining side."
      ]
    ]
  }
};


// =====================================================
// ADD DAY 3 → DAY 30 HERE
// =====================================================
//
// Example:
//
// 3: {
//   title: "Your Day 3 Title",
//   level: "FOUNDATION",
//   description: "Your description",
//   video: "https://www.youtube.com/watch?v=VIDEO_ID",
//   problems: [
//     ["Problem 1", "Description", "easy", "Hint"],
//     ["Problem 2", "Description", "easy", "Hint"],
//     ["Problem 3", "Description", "medium", "Hint"],
//     ["Problem 4", "Description", "medium", "Hint"],
//     ["Problem 5", "Description", "hard", "Hint"]
//   ]
// }


// =====================================================
// CONSTANTS
// =====================================================

const TOTAL_DAYS = 30;
const PROBLEMS_PER_DAY = 5;
const TOTAL_PROBLEMS = TOTAL_DAYS * PROBLEMS_PER_DAY;


// =====================================================
// STATE
// =====================================================

let state = JSON.parse(
  localStorage.getItem("logic30State") || "{}"
);

state.solved = state.solved || {};
state.bookmarks = state.bookmarks || [];

state.theme =
  state.theme ||
  localStorage.getItem("logic30Theme") ||
  "light";


// =====================================================
// HELPERS
// =====================================================

function $(id) {
  return document.getElementById(id);
}


function solvedFor(day) {
  return new Set(state.solved[day] || []);
}


function saveState() {
  localStorage.setItem(
    "logic30State",
    JSON.stringify(state)
  );
}


function completedCount() {
  return Object.values(state.solved).reduce(
    (total, arr) => total + arr.length,
    0
  );
}


function completedDays() {
  let count = 0;

  for (let day = 1; day <= TOTAL_DAYS; day++) {
    if (
      (state.solved[day] || []).length ===
      PROBLEMS_PER_DAY
    ) {
      count++;
    }
  }

  return count;
}


function currentDay() {
  for (let day = 1; day <= TOTAL_DAYS; day++) {
    if (
      (state.solved[day] || []).length <
      PROBLEMS_PER_DAY
    ) {
      return day;
    }
  }

  return TOTAL_DAYS;
}


function streak() {
  let result = 0;

  for (let day = 1; day <= TOTAL_DAYS; day++) {
    if (
      (state.solved[day] || []).length ===
      PROBLEMS_PER_DAY
    ) {
      result++;
    } else {
      break;
    }
  }

  return result;
}


function getPercent() {
  return Math.round(
    (completedCount() / TOTAL_PROBLEMS) * 100
  );
}


// =====================================================
// ICONS
// =====================================================

function refreshIcons() {
  if (
    window.lucide &&
    typeof window.lucide.createIcons === "function"
  ) {
    window.lucide.createIcons();
  }
}


// =====================================================
// TOAST
// =====================================================

function showToast(message) {
  const toast = $("toast");

  if (!toast) return;

  $("toastText").textContent = message;

  toast.classList.add("show");

  clearTimeout(showToast.timer);

  showToast.timer = setTimeout(() => {
    toast.classList.remove("show");
  }, 1800);
}


// =====================================================
// THEME
// =====================================================

function applyTheme() {
  document.documentElement.dataset.theme =
    state.theme;

  localStorage.setItem(
    "logic30Theme",
    state.theme
  );

  const themeButton = $("themeBtn");

  if (themeButton) {
    themeButton.innerHTML = `
      <i data-lucide="${
        state.theme === "dark"
          ? "moon"
          : "sun"
      }"></i>
    `;
  }

  refreshIcons();
}


// =====================================================
// GLOBAL PROGRESS UI
// =====================================================

function updateProgressUI() {
  const completed = completedCount();
  const percentage = getPercent();
  const day = currentDay();
  const daysDone = completedDays();
  const currentStreak = streak();

  // Dashboard
  if ($("heroSolved"))
    $("heroSolved").textContent = completed;

  if ($("summarySolved"))
    $("summarySolved").textContent = completed;

  if ($("heroDay"))
    $("heroDay").textContent = day;

  if ($("heroPct"))
    $("heroPct").textContent =
      `${percentage}%`;

  if ($("ringPct"))
    $("ringPct").textContent =
      `${percentage}%`;

  if ($("progressRing")) {
    $("progressRing").style.setProperty(
      "--percent",
      percentage
    );
  }

  if ($("globalBar"))
    $("globalBar").style.width =
      `${percentage}%`;

  // Challenge
  if ($("sideBar"))
    $("sideBar").style.width =
      `${percentage}%`;

  if ($("sidePercent"))
    $("sidePercent").textContent =
      `${percentage}%`;

  // Progress page
  if ($("statSolved"))
    $("statSolved").textContent =
      completed;

  if ($("statPct"))
    $("statPct").textContent =
      `${percentage}%`;

  if ($("statDay"))
    $("statDay").textContent =
      day;

  if ($("statDays"))
    $("statDays").textContent =
      daysDone;

  if ($("summaryStreak"))
    $("summaryStreak").textContent =
      currentStreak;
}


// =====================================================
// NAVIGATION
// =====================================================

function navigateTo(viewName, title) {
  document
    .querySelectorAll(".view")
    .forEach(view => {
      view.classList.remove("active");
    });

  const target =
    $(`view-${viewName}`);

  if (target) {
    target.classList.add("active");
  }

  const breadcrumb =
    $("breadcrumbCurrent");

  if (breadcrumb) {
    breadcrumb.textContent =
      title || viewName;
  }

  document
    .querySelectorAll(".nav-item")
    .forEach(button => {
      button.classList.toggle(
        "active",
        button.dataset.view === viewName
      );
    });

  const sidebar =
    $("sidebar");

  if (sidebar) {
    sidebar.classList.remove("open");
  }

  window.scrollTo({
    top: 0,
    behavior: "smooth"
  });
}


// =====================================================
// DASHBOARD ROADMAP
// =====================================================

function renderRoadmap() {
  const container =
    $("dashboardRoadmap");

  if (!container) return;

  container.innerHTML = "";

  for (
    let day = 1;
    day <= TOTAL_DAYS;
    day++
  ) {
    const available =
      Boolean(DAYS[day]);

    const completed =
      solvedFor(day).size ===
      PROBLEMS_PER_DAY;

    const button =
      document.createElement("button");

    button.className =
      `road-day ${
        completed ? "done" : ""
      }`;

    button.innerHTML = `
      <strong>
        ${String(day).padStart(2, "0")}
      </strong>

      <span>
        ${
          available
            ? completed
              ? "Done"
              : "Open"
            : "Soon"
        }
      </span>
    `;

    button.disabled = !available;

    if (available) {
      button.addEventListener(
        "click",
        () => openDay(day)
      );
    }

    container.appendChild(button);
  }
}


// =====================================================
// CHALLENGE DAYS
// =====================================================

function renderDays(filter = "all") {
  const container =
    $("dayList");

  if (!container) return;

  container.innerHTML = "";

  for (
    let day = 1;
    day <= TOTAL_DAYS;
    day++
  ) {
    const available =
      Boolean(DAYS[day]);

    const completed =
      solvedFor(day).size ===
      PROBLEMS_PER_DAY;

    if (
      filter === "available" &&
      !available
    ) {
      continue;
    }

    if (
      filter === "completed" &&
      !completed
    ) {
      continue;
    }

    const row =
      document.createElement("button");

    row.className =
      `day-row ${
        completed ? "completed" : ""
      }`;

    row.innerHTML = `
      <div class="day-index">
        ${String(day).padStart(2, "0")}
      </div>

      <div>
        <h3>
          ${
            available
              ? DAYS[day].title
              : "Coming soon"
          }
        </h3>

        <p>
          ${
            available
              ? DAYS[day].level
              : "This day will be unlocked when content is added."
          }
        </p>
      </div>

      <div class="day-row-status">
        ${
          completed
            ? "Completed"
            : available
              ? `${solvedFor(day).size}/5`
              : "Locked"
        }
      </div>
    `;

    row.disabled = !available;

    if (available) {
      row.addEventListener(
        "click",
        () => openDay(day)
      );
    }

    container.appendChild(row);
  }
}


// =====================================================
// TODAY
// =====================================================

function renderToday() {
  const day = Math.min(
    currentDay(),
    TOTAL_DAYS
  );

  const data =
    DAYS[day] || DAYS[1];

  if ($("todayNumber"))
    $("todayNumber").textContent =
      String(day).padStart(2, "0");

  if ($("todayTitle"))
    $("todayTitle").textContent =
      data.title;

  if ($("todayDesc"))
    $("todayDesc").textContent =
      data.description;
}


// =====================================================
// OPEN DAY
// =====================================================

function openDay(day) {
  if (!DAYS[day]) {
    showToast(
      "This day is coming soon"
    );

    return;
  }

  navigateTo(
    "day",
    `Day ${String(day).padStart(2, "0")}`
  );

  renderProblems(day);
}


// =====================================================
// RENDER PROBLEMS
// =====================================================

function renderProblems(day) {
  const data = DAYS[day];

  if (!data) return;

  const solved =
    solvedFor(day);

  const detailLevel =
    $("detailLevel");

  const detailTitle =
    $("detailTitle");

  const detailDesc =
    $("detailDesc");

  const detailScore =
    $("detailScore");

  if (detailLevel) {
    detailLevel.textContent =
      `DAY ${String(day).padStart(
        2,
        "0"
      )} · ${data.level}`;
  }

  if (detailTitle) {
    detailTitle.textContent =
      data.title;
  }

  if (detailDesc) {
    detailDesc.textContent =
      data.description;
  }

  if (detailScore) {
    detailScore.textContent =
      `${solved.size} / ${PROBLEMS_PER_DAY}`;
  }

  const video =
    $("dayVideo");

  if (video) {
    if (data.video) {
      video.href = data.video;
      video.style.pointerEvents =
        "auto";
      video.style.opacity = "1";
    } else {
      video.href = "#";
      video.style.pointerEvents =
        "none";
      video.style.opacity = ".45";
    }
  }

  const list =
    $("problemList");

  if (!list) return;

  list.innerHTML = "";

  data.problems.forEach(
    (problem, index) => {
      const number =
        index + 1;

      const isSolved =
        solved.has(number);

      const isBookmarked =
        state.bookmarks.some(
          item =>
            item.day === day &&
            item.problem === number
        );

      const card =
        document.createElement("article");

      card.className =
        `problem-card ${
          isSolved ? "solved" : ""
        }`;

      card.innerHTML = `
        <div class="problem-top">

          <span class="problem-num">
            PROBLEM ${String(number).padStart(
              2,
              "0"
            )}
          </span>

          <span class="difficulty ${problem[2]}">
            ${problem[2].toUpperCase()}
          </span>

        </div>

        <h3>
          ${problem[0]}
        </h3>

        <p>
          ${problem[1]}
        </p>

        <div class="problem-actions">

          <button
            class="tiny-btn solve"
            data-action="solve"
          >
            <i data-lucide="${
              isSolved
                ? "check"
                : "circle-check"
            }"></i>

            ${
              isSolved
                ? "Completed"
                : "Mark complete"
            }
          </button>

          <button
            class="tiny-btn"
            data-action="hint"
          >
            <i data-lucide="lightbulb"></i>
            Hint
          </button>

          <button
            class="tiny-btn"
            data-action="bookmark"
          >
            <i data-lucide="${
              isBookmarked
                ? "bookmark-check"
                : "bookmark"
            }"></i>

            ${
              isBookmarked
                ? "Saved"
                : "Save"
            }
          </button>

        </div>

        <div class="hint">
          <strong>Hint:</strong>
          ${problem[3]}
        </div>
      `;

      card
        .querySelector(
          '[data-action="solve"]'
        )
        .addEventListener(
          "click",
          () =>
            toggleSolved(
              day,
              number
            )
        );

      card
        .querySelector(
          '[data-action="hint"]'
        )
        .addEventListener(
          "click",
          () =>
            card.classList.toggle(
              "show-hint"
            )
        );

      card
        .querySelector(
          '[data-action="bookmark"]'
        )
        .addEventListener(
          "click",
          () =>
            toggleBookmark(
              day,
              number
            )
        );

      list.appendChild(card);
    }
  );

  refreshIcons();
}


// =====================================================
// SOLVE / UNSOLVE
// =====================================================

function toggleSolved(
  day,
  problemNumber
) {
  const solved =
    state.solved[day] || [];

  const index =
    solved.indexOf(problemNumber);

  if (index >= 0) {
    solved.splice(index, 1);

    showToast(
      "Marked as incomplete"
    );
  } else {
    solved.push(problemNumber);

    solved.sort(
      (a, b) => a - b
    );

    showToast(
      "Problem completed"
    );
  }

  state.solved[day] =
    solved;

  saveState();

  updateProgressUI();
  renderAll();
  renderProblems(day);
}


// =====================================================
// BOOKMARKS
// =====================================================

function toggleBookmark(
  day,
  problemNumber
) {
  const index =
    state.bookmarks.findIndex(
      item =>
        item.day === day &&
        item.problem ===
          problemNumber
    );

  if (index >= 0) {
    state.bookmarks.splice(
      index,
      1
    );

    showToast(
      "Removed from bookmarks"
    );
  } else {
    state.bookmarks.push({
      day,
      problem: problemNumber
    });

    showToast(
      "Saved to bookmarks"
    );
  }

  saveState();

  renderBookmarks();

  renderProblems(day);
}


// =====================================================
// VIDEO / RESOURCES
// =====================================================

function renderVideos() {
  const container =
    $("videoGrid");

  if (!container) return;

  container.innerHTML = "";

  for (
    let day = 1;
    day <= TOTAL_DAYS;
    day++
  ) {
    if (!DAYS[day]) continue;

    const data =
      DAYS[day];

    const hasVideo =
      Boolean(data.video);

    const card =
      document.createElement("article");

    card.className =
      "video-card";

    card.innerHTML = `
      <div class="video-thumb">
        <i data-lucide="play"></i>
      </div>

      <div class="video-body">

        <span>
          DAY ${String(day).padStart(
            2,
            "0"
          )}
        </span>

        <h3>
          ${data.title}
        </h3>

        <p>
          ${
            hasVideo
              ? "Watch the lesson for today's concept."
              : "Add a YouTube URL in script.js to activate this lesson."
          }
        </p>

        <a
          class="btn ${
            hasVideo
              ? "btn-dark"
              : "btn-outline"
          }"
          href="${
            hasVideo
              ? data.video
              : "#"
          }"
          ${
            hasVideo
              ? 'target="_blank" rel="noopener noreferrer"'
              : ""
          }
        >
          ${
            hasVideo
              ? "Watch lesson"
              : "Add video first"
          }

          <i data-lucide="arrow-up-right"></i>
        </a>

      </div>
    `;

    container.appendChild(card);
  }

  refreshIcons();
}


// =====================================================
// PROGRESS TABLE
// =====================================================

function renderProgressTable() {
  const container =
    $("progressTable");

  if (!container) return;

  container.innerHTML = "";

  for (
    let day = 1;
    day <= TOTAL_DAYS;
    day++
  ) {
    const solved =
      solvedFor(day).size;

    const data =
      DAYS[day];

    const row =
      document.createElement("div");

    row.className =
      "progress-row";

    row.innerHTML = `
      <strong>
        Day ${String(day).padStart(
          2,
          "0"
        )}
      </strong>

      <span>
        ${
          data
            ? data.title
            : "Coming soon"
        }
      </span>

      <div class="progress-mini">
        <div
          style="width:${solved * 20}%"
        ></div>
      </div>

      <span>
        ${solved}/5
      </span>
    `;

    container.appendChild(row);
  }
}


// =====================================================
// BOOKMARK PAGE
// =====================================================

function renderBookmarks() {
  const container =
    $("bookmarkList");

  if (!container) return;

  if (
    state.bookmarks.length === 0
  ) {
    container.innerHTML = `
      <div class="empty">
        No bookmarks yet.
        Save a problem from a day page
        and it will appear here.
      </div>
    `;

    return;
  }

  container.innerHTML =
    state.bookmarks
      .map(item => {

        const problem =
          DAYS[item.day]
            ?.problems[
              item.problem - 1
            ];

        if (!problem) return "";

        return `
          <div class="bookmark-card">

            <i data-lucide="bookmark"></i>

            <div>

              <strong>
                Day ${String(item.day).padStart(
                  2,
                  "0"
                )}
                ·
                ${problem[0]}
              </strong>

              <span>
                ${problem[1]}
              </span>

            </div>

          </div>
        `;
      })
      .join("");

  refreshIcons();
}


// =====================================================
// REFRESH EVERYTHING
// =====================================================

function renderAll() {
  updateProgressUI();
  renderRoadmap();
  renderDays();
  renderToday();
  renderVideos();
  renderProgressTable();
  renderBookmarks();
}


// =====================================================
// NAV BUTTONS
// =====================================================

document
  .querySelectorAll(".nav-item")
  .forEach(button => {

    button.addEventListener(
      "click",
      () => {

        navigateTo(
          button.dataset.view,
          button.textContent.trim()
        );

      }
    );

  });


// =====================================================
// DATA-GO BUTTONS
// =====================================================

document
  .querySelectorAll("[data-go]")
  .forEach(button => {

    button.addEventListener(
      "click",
      () => {

        const destination =
          button.dataset.go;

        navigateTo(
          destination,
          destination === "challenge"
            ? "30 Day Challenge"
            : "Dashboard"
        );

      }
    );

  });


// =====================================================
// FILTERS
// =====================================================

document
  .querySelectorAll(".filter-chip")
  .forEach(button => {

    button.addEventListener(
      "click",
      () => {

        document
          .querySelectorAll(
            ".filter-chip"
          )
          .forEach(item =>
            item.classList.remove(
              "active"
            )
          );

        button.classList.add(
          "active"
        );

        renderDays(
          button.dataset.filter
        );

      }
    );

  });


// =====================================================
// BACK BUTTON
// =====================================================

const backChallenge =
  $("backChallenge");

if (backChallenge) {

  backChallenge.addEventListener(
    "click",
    () =>
      navigateTo(
        "challenge",
        "30 Day Challenge"
      )
  );

}


// =====================================================
// MOBILE MENU
// =====================================================

const menuButton =
  $("menuBtn");

if (menuButton) {

  menuButton.addEventListener(
    "click",
    () => {

      const sidebar =
        $("sidebar");

      if (sidebar) {
        sidebar.classList.toggle(
          "open"
        );
      }

    }
  );

}


// =====================================================
// THEME BUTTON
// =====================================================

const themeButton =
  $("themeBtn");

if (themeButton) {

  themeButton.addEventListener(
    "click",
    () => {

      state.theme =
        state.theme === "dark"
          ? "light"
          : "dark";

      saveState();

      applyTheme();

    }
  );

}


// =====================================================
// INITIALIZE
// =====================================================

applyTheme();

renderAll();

refreshIcons();