import { D as DateRangePicker } from "./vendor.js";
const datepicker = document.querySelector("[date-rangepicker]");
new DateRangePicker(datepicker, {
  format: "yyyy-mm-dd",
  allowOneSidedRange: true,
  inputs: [document.querySelector('[name="start"]'), document.querySelector('[name="end"]')]
});
const todayButton = document.getElementById("today-button");
const weekButton = document.getElementById("week-button");
const lastMonthButton = document.getElementById("last-month-button");
const thisMonthButton = document.getElementById("this-month-button");
todayButton == null ? void 0 : todayButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const start = today.toISOString().split("T")[0];
  const end = today.toISOString().split("T")[0];
  document.querySelector('[name="start"]').value = start;
  document.querySelector('[name="end"]').value = end;
});
weekButton == null ? void 0 : weekButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const start = new Date(today.setDate(today.getDate() - today.getDay()));
  const end = new Date(today.setDate(today.getDate() - today.getDay() + 6));
  document.querySelector('[name="start"]').value = start.toISOString().split("T")[0];
  document.querySelector('[name="end"]').value = end.toISOString().split("T")[0];
});
lastMonthButton == null ? void 0 : lastMonthButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const start = new Date(today.getFullYear(), today.getMonth() - 1, 1);
  const end = new Date(today.getFullYear(), today.getMonth(), 0);
  document.querySelector('[name="start"]').value = start.toISOString().split("T")[0];
  document.querySelector('[name="end"]').value = end.toISOString().split("T")[0];
});
thisMonthButton == null ? void 0 : thisMonthButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const start = new Date(today.getFullYear(), today.getMonth(), 1);
  const end = new Date(today.getFullYear(), today.getMonth() + 1, 0);
  document.querySelector('[name="start"]').value = start.toISOString().split("T")[0];
  document.querySelector('[name="end"]').value = end.toISOString().split("T")[0];
});
const sixMonthButton = document.getElementById("six-month-button");
const oneYearButton = document.getElementById("one-year-button");
const threeYearButton = document.getElementById("three-year-button");
const fiveYearButton = document.getElementById("five-year-button");
sixMonthButton == null ? void 0 : sixMonthButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const sixMonthAgo = new Date(today.setMonth(today.getMonth() - 6));
  const todayDate = (/* @__PURE__ */ new Date()).toISOString().split("T")[0];
  const sixMonthAgoDate = sixMonthAgo.toISOString().split("T")[0];
  document.querySelector('input[name="start"]').value = sixMonthAgoDate;
  document.querySelector('input[name="end"]').value = todayDate;
});
oneYearButton == null ? void 0 : oneYearButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const oneYearAgo = new Date(today.setFullYear(today.getFullYear() - 1));
  const todayDate = (/* @__PURE__ */ new Date()).toISOString().split("T")[0];
  const oneYearAgoDate = oneYearAgo.toISOString().split("T")[0];
  document.querySelector('input[name="start"]').value = oneYearAgoDate;
  document.querySelector('input[name="end"]').value = todayDate;
});
threeYearButton == null ? void 0 : threeYearButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const threeYearAgo = new Date(today.setFullYear(today.getFullYear() - 3));
  const todayDate = (/* @__PURE__ */ new Date()).toISOString().split("T")[0];
  const threeYearAgoDate = threeYearAgo.toISOString().split("T")[0];
  document.querySelector('input[name="start"]').value = threeYearAgoDate;
  document.querySelector('input[name="end"]').value = todayDate;
});
fiveYearButton == null ? void 0 : fiveYearButton.addEventListener("click", () => {
  const today = /* @__PURE__ */ new Date();
  const fiveYearAgo = new Date(today.setFullYear(today.getFullYear() - 5));
  const todayDate = (/* @__PURE__ */ new Date()).toISOString().split("T")[0];
  const fiveYearAgoDate = fiveYearAgo.toISOString().split("T")[0];
  document.querySelector('input[name="start"]').value = fiveYearAgoDate;
  document.querySelector('input[name="end"]').value = todayDate;
});
